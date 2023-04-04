package com.example.lq;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Home extends AppCompatActivity {
    MaterialCardView easycard,  hardcard ,difficultcard ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        easycard = findViewById(R.id.easyCard);
        hardcard= findViewById(R.id.hardCard);
        difficultcard = findViewById(R.id.difficultCard);
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(Home.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Y wnat quiz.?");

        materialAlertDialogBuilder.setNegativeButton(android.R.string.no,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();
            }
        });
        materialAlertDialogBuilder.show();




    }
}