package com.example.diabetesmanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.login_toolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void correctCred(String resp, Intent intent) {
        if (resp.equals("OK")) {
            startActivity(intent);
        }
        else {
            Log.e("err", "err");
            ((TextView)findViewById(R.id.errorMessageLogin)).setText("Wrong username or password.");
        }
    }

    public void volleyPost(String email, String pass, Intent intent){
        RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("192.168.43.22")
                .appendPath("diabetes_manager")
                .appendPath("server.php")
                .appendQueryParameter("email", email)
                .appendQueryParameter("pass", pass);
        String JSONurl = builder.build().toString();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSONurl, null,
                response -> {
                    try {
                        Log.e("succes: ", (String) response.get("result"));
                        correctCred((String) response.get("result"), intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    error.printStackTrace();
                });
        requestQueue.add(jsonObjectRequest);
    }

    public void loginCred(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
        String pass = ((EditText) findViewById(R.id.passEditText)).getText().toString();
        volleyPost(email, pass, intent);
    }
}