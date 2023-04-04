package com.example.lq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class selectLevels extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView imageView;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_levels);

        //Assign Variable
        drawerLayout =findViewById(R.id.drawer_layout);




    }


public void Clickmenu(View view){

        openDrawer(drawerLayout);
}

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }


    }

    public void ClickHome(View view){
        recreate();

    }
     public void ClickTopic(View view){
        redirectActivity(this,Topic.class);
     }
     public void ClickAbout(View view){
        redirectActivity(this,About.class);
     }
     public void ClickShare(View view){
        redirectActivity(this,Share.class);
     }
     public void ClickReatUs(View view){
        redirectActivity(this,ReatUs.class);
     }

    public static void redirectActivity(Activity activity,Class aClass)
    {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }


    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}