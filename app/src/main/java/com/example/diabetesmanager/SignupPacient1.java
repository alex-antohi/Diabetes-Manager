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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SignupPacient1 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_pacient1);

        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.signupPacient1_toolbar);
        setSupportActionBar(myChildToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void next1(View view) {
        Intent intent = new Intent(this, SignupPacient2.class);
        String firstName = ((EditText) findViewById(R.id.firstNameEditPacient)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastNameEditPacient)).getText().toString();
        String disease = ((Spinner) findViewById(R.id.diseaseEditPacient)).getSelectedItem().toString();
        String treatment = ((Spinner) findViewById(R.id.editTreatmentPacient)).getSelectedItem().toString();
        String phoneNumber = ((EditText) findViewById(R.id.editPhoneNumberPacient)).getText().toString();
        String[] data = {firstName, lastName, disease, treatment, phoneNumber};
        List<String> dataList = Arrays.asList(data);
        if (!dataList.contains("") && !dataList.contains("Select One")) {
            intent.putExtra(EXTRA_MESSAGE, data);
            startActivity(intent);
        }
    }
}