package com.example.lq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplachScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent Home =new Intent(SplachScreen.this,MainActivity.class);
                startActivity(Home);
                finish();  // stop the showing screen after splach


            }
        }, 5000);

    }
}