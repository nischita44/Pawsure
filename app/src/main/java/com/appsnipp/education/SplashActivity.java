/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {


        private static boolean splashLoaded = false;
        @Override    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (!splashLoaded) {
                setContentView(R.layout.activity_splash);
                int secondsDelayed = 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                }, secondsDelayed * 2500);
                splashLoaded = true;
            }
            else {
                Intent goToMainActivity = new Intent(SplashActivity.this, LoginActivity.class);
                goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(goToMainActivity);
                finish();
            }
        }

}