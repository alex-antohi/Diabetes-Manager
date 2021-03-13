package com.example.diabetesmanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.Arrays;
import java.util.List;

public class SignupDoctor2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_doctor2);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.signupDoctor2_toolbar);
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
        }
    }

    public void sendToServer(String email, String pass, Intent intent) {
        Bundle extra = getIntent().getExtras();
        RequestQueue requestQueue= Volley.newRequestQueue(SignupDoctor2.this);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("192.168.43.22")
                .appendPath("diabetes_manager")
                .appendPath("server.php")
                .appendQueryParameter("firstName", (String) extra.get("firstName"))
                .appendQueryParameter("lastName", (String) extra.get("lastName"))
                .appendQueryParameter("speciality", (String) extra.get("speciality"))
                .appendQueryParameter("phoneNumber", (String) extra.get("phoneNumber"))
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

    public void next2(View view) {
        Intent intent = new Intent(this, SignupDoctor3.class);
        String email = ((EditText) findViewById(R.id.emailEditSignupDoctor)).getText().toString();
        String pass = ((EditText) findViewById(R.id.passEditSignupDoctor)).getText().toString();
        String passConf = ((EditText) findViewById(R.id.passConfEditSignupDoctor)).getText().toString();
        String[] data = {email, pass, passConf};
        List<String> dataList = Arrays.asList(data);
        if (!dataList.contains("") && pass.equals(passConf)) {
            sendToServer(email, pass, intent);
//            startActivity(intent);
        }
    }
}