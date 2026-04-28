package com.example.todolist3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class SettingsPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch DarkModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingspage);

        DarkModeSwitch = findViewById(R.id.switchTheme);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);


        DarkModeSwitch.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }));




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
