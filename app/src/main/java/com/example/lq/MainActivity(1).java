package com.example.lq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
      Button button,buttonR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        button = findViewById(R.id.login_btn);
       buttonR =findViewById(R.id.login_btn1);


   

        button.setOnClickListener(v -> {
            Intent i =new Intent(MainActivity.this,login.class);
            startActivity(i);

        });
         buttonR.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i =new Intent(MainActivity.this,signup.class);
                 startActivity(i);

             }
         });




    }
}