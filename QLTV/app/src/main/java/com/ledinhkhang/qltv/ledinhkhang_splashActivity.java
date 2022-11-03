package com.ledinhkhang.qltv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ledinhkhang_splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledinhkhang_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ledinhkhang_splashActivity.this,ledinhkhang_activityLogin.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}