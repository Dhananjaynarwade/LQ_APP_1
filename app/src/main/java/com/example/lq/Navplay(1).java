package com.example.lq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Navplay extends AppCompatActivity {
    CardView  js;
    CardView  java;
    CardView   android;
    CardView python;
    CardView   cprogramin ;
    CardView       oops;
    CardView       html;
    CardView       css;
    CardView       monhodb;
    CardView       mysql;
    CardView       csharp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_navplay);

  python= findViewById(R.id.cV_navpaython);
  android=findViewById(R.id.cV_nav_android);
  java=findViewById(R.id.cV_navjava);
  js=findViewById(R.id.cV_navjs);
  cprogramin=findViewById(R.id.cV_nav_cprogramin);
  oops=findViewById(R.id.cV_nav_Coops);
  html=findViewById(R.id.cV_nav_html);
  css=findViewById(R.id.cV_nav_css);
  monhodb=findViewById(R.id.cV_nav_mongodb);
  mysql= findViewById(R.id.cV_nav_mysql);
  csharp=findViewById(R.id.cV_nav_csharp);

        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,jsnav_info.class));


            }
        });
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,javanav_info.class));


            }
        });


  android.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          startActivity(new Intent(Navplay.this,androidnav_info.class));


      }
  });
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,python_info.class));
            }
        });
        cprogramin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,cnav_info.class));


            }
        });
        oops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,oopsnav_info.class));

            }
        });
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,oopsnav_info.class));

            }
        });
        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,cssnav_info.class));

            }
        });
        monhodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,mongodbnav_info.class));

            }
        });
        mysql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,mysqlnav_info.class));

            }
        });
        csharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Navplay.this,csharpnav_info.class));

            }
        });









//         gridList();
//
//         myAdapter = new MyAdapter(this,list);
//         gridView1.setAdapter((ListAdapter) myAdapter);










//    private void gridList() {
//        list = new ArrayList<>();
//        list.add(new Pojo(R.drawable.javad));
//        list.add(new Pojo(R.drawable.pythond));
//        list.add(new Pojo(R.drawable.as));
//        list.add(new Pojo(R.drawable.ej));
//        list.add(new Pojo(R.drawable.html));
//        list.add(new Pojo(R.drawable.css));
//        list.add(new Pojo(R.drawable.mysql));
//        list.add(new Pojo(R.drawable.cprograming));
//        list.add(new Pojo(R.drawable.js));
//        list.add(new Pojo(R.drawable.mongodb));
//        list.add(new Pojo(R.drawable.charp));
//        list.add(new Pojo(R.drawable.oobs));
//
//
//    }
    }






}