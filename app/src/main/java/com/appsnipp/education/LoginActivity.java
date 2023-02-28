/*
 * Copyright (c) 2022. rogergcc
 */

package com.appsnipp.education;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button) findViewById(R.id.button);
        Button reg = (Button) findViewById(R.id.button2);
        EditText userName = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword3) ;
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                login.setBackgroundResource(R.drawable.login2);
                String sUsername = userName.getText().toString();
                if (sUsername.matches("") || password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                }else {
                    Intent goToMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(goToMainActivity);
                    finish();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg.setBackgroundResource(R.drawable.login4);

                Intent goToMainActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(goToMainActivity);
                finish();
            }
        });

    }
}