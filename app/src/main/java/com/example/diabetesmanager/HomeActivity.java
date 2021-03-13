package com.example.diabetesmanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(myChildToolbar);
    }

    public void testServer(View view) throws IOException {
        RequestQueue requestQueue = Volley.newRequestQueue(HomeActivity.this);
        String url = "http://192.168.43.22/diabetes_manager/server.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
//                    JSONObject jsonObject = new JSONObject(response);
                    Log.e("Success",  response.toString());
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
//                    Log.e("Error:", "naspa");
                    Log.e("Error:", error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}