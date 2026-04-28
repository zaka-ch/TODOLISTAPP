package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingspage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Handle Logout
        buttonLogout.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsPage.this, MainActivity.class);
            // Clear the activity stack so user can't go back
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

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
