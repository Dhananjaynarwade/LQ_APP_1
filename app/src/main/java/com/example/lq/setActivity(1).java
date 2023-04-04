package com.example.lq;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class setActivity extends AppCompatActivity {


    Toolbar toolbar;
    TextView textView;

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        Toolbar toolbar = findViewById(R.id.setTollBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("TItle"));

        gridView= findViewById(R.id.gridView_forsetTopic);



    }

}