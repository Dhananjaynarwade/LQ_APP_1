package com.example.lq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class jsnav_info extends AppCompatActivity {
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsnav_info);

        button=findViewById(R.id.btn_js_quizbtn);
        button.setOnClickListener(view -> {
            Toast.makeText(jsnav_info.this, "u click on js btn", Toast.LENGTH_SHORT).show();
            Intent intent1= new Intent(jsnav_info.this,quiz_js.class);
            startActivity(intent1);
            finish();
        });

    }

}