package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingspage);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        /// NAVBAR Settings page

        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);

        bottomNavigationView.setOnItemSelectedListener(MenuItem -> {
            int id = MenuItem.getItemId();

            if(id == R.id.navigation_tasks){
                startActivity(new Intent(SettingsPage.this, LandingPage.class));
            } else if (id == R.id.navigation_upcoming) {
                startActivity(new Intent(SettingsPage.this, UpcomingPage.class));
                return true;
            } else return id == R.id.navigation_settings;

            return false;
        });
    }
}
