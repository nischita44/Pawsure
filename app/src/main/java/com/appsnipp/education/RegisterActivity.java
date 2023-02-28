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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button reg = (Button) findViewById(R.id.button2);
        EditText name = (EditText) findViewById(R.id.editTextName);
        EditText email = (EditText) findViewById(R.id.editTextEnterEmail) ;
        EditText pwd = (EditText) findViewById(R.id.editTextEnterPassword) ;
        EditText cpwd = (EditText) findViewById(R.id.editTextTextEmailAddress) ;
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = name.getText().toString();
                String semail = email.getText().toString();
                String spwd = pwd.getText().toString();
                String scpwd = cpwd.getText().toString();
                reg.setBackgroundResource(R.drawable.login2);


                if (sname.matches("") || semail.matches("") || spwd.matches("") || scpwd.matches("")) {
                    Toast.makeText(RegisterActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();


                }
                else if(pwd.getText().toString().equals( cpwd.getText().toString())){
                    Intent goToMainActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(goToMainActivity);
                    finish();
                }


                else {
                    Toast.makeText(RegisterActivity.this, "Password Does not match", Toast.LENGTH_SHORT).show();

                }
            }

        });
}

}
