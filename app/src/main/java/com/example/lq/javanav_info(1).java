package com.example.lq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;


public class javanav_info extends AppCompatActivity {
    MaterialCardView EasyCard, HardCard,DifficultCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javanav_info);

        EasyCard=findViewById(R.id.EasyCard_js1);
        HardCard=findViewById(R.id.HardCard_js);
        DifficultCard=findViewById(R.id.DifficultCard_js);


        EasyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(javanav_info.this,Easy_level_js.class);
                startActivity(intent);
            }
        });



        HardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(javanav_info.this,HardLevels_js.class);
                startActivity(intent);
//                finish();

            }
        });

       DifficultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(javanav_info.this,Difficult_Levels_js.class);
                startActivity(intent);
//                finish();
            }
        });
    }
}