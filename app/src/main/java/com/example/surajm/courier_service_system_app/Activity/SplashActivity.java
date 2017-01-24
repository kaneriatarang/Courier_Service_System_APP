package com.example.surajm.courier_service_system_app.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.surajm.courier_service_system_app.R;

public class SplashActivity extends AppCompatActivity {
    private static int splashintvar = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,Login_mainActivity.class);
                startActivity(i);
                this.finish();

            }
            private void finish(){}
        },splashintvar);
    }
}
