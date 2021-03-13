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

public class SignupDoctor1 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_doctor1);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.signupDoctor1_toolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void next1(View view) {
        Intent intent = new Intent(this, SignupDoctor2.class);
        String firstName = ((EditText) findViewById(R.id.firstNameEditDoctor)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastNameEditDoctor)).getText().toString();
        String speciality = ((EditText) findViewById(R.id.editSpeciality)).getText().toString();
        String phoneNumber = ((EditText) findViewById(R.id.editPhoneNumberDoctor)).getText().toString();
        String[] data = {firstName, lastName, speciality, phoneNumber};
        List<String> dataList = Arrays.asList(data);
        if (!dataList.contains("") && !dataList.contains("Select One")) {
            intent.putExtra("firstName", firstName);
            intent.putExtra("lastName", lastName);
            intent.putExtra("speciality", speciality);
            intent.putExtra("phoneNumber", phoneNumber);
            startActivity(intent);
        }
    }
}