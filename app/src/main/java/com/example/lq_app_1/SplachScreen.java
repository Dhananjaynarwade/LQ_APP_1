package com.example.lq_app_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SplachScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser =FirebaseAuth.getInstance().getCurrentUser();
                if (currentUser==null){
                    startActivity(new Intent(SplachScreen.this,login.class));
                }else {
                    startActivity(new Intent(SplachScreen.this,Startwindow.class));
                }
                finish();
    }
}