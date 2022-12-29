package com.example.lq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NavBar extends AppCompatActivity {
    public Button button;
    public  Button choise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_bar);
        Button button=findViewById(R.id.play_but);

      //   Play Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NavBar.this, Navplay.class);
                startActivity(intent);

            }
        });

        // Choise Button

/*
*
* star =(Button) findViewById(R.id.start_quiz_button);
star.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Startwindow.this,NavBar.class);
        startActivity(intent);
    }
}); */

choise =(Button) findViewById(R.id.Btton1c);
choise.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(NavBar.this,chisenav.class);
//        startActivity(intent);
    }
});

    }
}