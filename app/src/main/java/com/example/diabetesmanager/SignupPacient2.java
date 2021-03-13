package com.example.diabetesmanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class SignupPacient2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_pacient2);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.signupPacient2_toolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra(SignupPacient1.EXTRA_MESSAGE);
    }

    public void next2(View view) {
        Intent intent = new Intent(this, SignupPacient3.class);
        String email = ((EditText) findViewById(R.id.emailEditSignupPacient)).getText().toString();
        String pass = ((EditText) findViewById(R.id.passEditSignupPacient)).getText().toString();
        String passConf = ((EditText) findViewById(R.id.passConfEditSignupPacient)).getText().toString();
        String[] data = {email, pass, passConf};
        List<String> dataList = Arrays.asList(data);
        if (!dataList.contains("") && pass.equals(passConf)) {
            intent.putExtra(EXTRA_MESSAGE, data);
            startActivity(intent);
        }
    }
}