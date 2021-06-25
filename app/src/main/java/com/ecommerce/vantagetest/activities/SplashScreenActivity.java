package com.ecommerce.vantagetest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.ecommerce.vantagetest.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 2000;        // Splash time for keep the activity on hold for given time

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Method for making the statusBar explicitly colourful
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(R.color.theme_background);
        }

        // Method for moving from one activity to another using handler ***
        intentHandler();
    }

    private void intentHandler()
    {
        // using handler for auto moving from an activity to another
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish(); // Calling finish method for exit the application when it is back pressed from next activity
            }
        }, SPLASH_TIME);
    }
}