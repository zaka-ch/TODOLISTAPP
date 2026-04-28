package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;




public class UpcomingPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcomingpage);



        bottomNavigationView = findViewById(R.id.bottomNavigationView);




        bottomNavigationView.setSelectedItemId(R.id.navigation_upcoming);

        bottomNavigationView.setOnItemSelectedListener(MenuItem -> {
            int id = MenuItem.getItemId();

            if(id == R.id.navigation_tasks){
                startActivity(new Intent(UpcomingPage.this, LandingPage.class));
                return true;
            } else if (id == R.id.navigation_upcoming) {
                return true;
            } else if (id == R.id.navigation_settings) {
                startActivity(new Intent(UpcomingPage.this, SettingsPage.class));
                return true;
            }

            return false;
        });




    }
}
