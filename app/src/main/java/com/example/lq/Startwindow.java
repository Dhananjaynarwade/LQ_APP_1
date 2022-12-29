package com.example.lq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Startwindow extends AppCompatActivity {


//   Button Start or AnoutUs
    public Button star;
  public   Button About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startwindow);

star =(Button) findViewById(R.id.start_quiz_button);
star.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Startwindow.this,NavBar.class);
        startActivity(intent);
    }
});


Button About= findViewById(R.id.about_quiz_button);


About.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Startwindow.this,aboutUs.class);
        startActivity(intent);
    }
});








    }
}