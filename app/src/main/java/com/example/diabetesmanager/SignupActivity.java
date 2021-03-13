package com.example.diabetesmanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.signup_toolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void signupDoctor(View view) {
        Intent intent = new Intent(this, SignupDoctor1.class);
        startActivity(intent);
    }

    public void signupPacient(View view) {
        Intent intent = new Intent(this, SignupPacient1.class);
        startActivity(intent);
    }
}