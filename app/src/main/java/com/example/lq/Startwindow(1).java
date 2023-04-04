package com.example.lq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Startwindow extends AppCompatActivity {
//    MaterialToolbar toolbar;
//    DrawerLayout drawerLayout;
//    FrameLayout frameLayout;
//
//    NavigationView navigationView;
Button game;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startwindow);







//     Button   star =findViewById(R.id.start_quiz_button);
//
//star.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(Startwindow.this,NavBar.class);
//        startActivity(intent);
//    }
//});
Button star=findViewById(R.id.start);
star.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
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
game=findViewById(R.id.game);









    }
}