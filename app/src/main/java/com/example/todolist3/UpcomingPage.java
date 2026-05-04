package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class UpcomingPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView rvUpcomingTasks;
    TaskAdapter taskAdapter;
    List<Task> upcomingTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcomingpage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        rvUpcomingTasks = findViewById(R.id.rvUpcomingTasks);

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

        loadUpcomingTasks();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadUpcomingTasks();
    }

    private void loadUpcomingTasks() {
        upcomingTasks = new ArrayList<>();
        for (Task task : LandingPage.tasks) {
            if (!task.isChecked()) {
                upcomingTasks.add(task);
            }
        }

        taskAdapter = new TaskAdapter(upcomingTasks, this);
        rvUpcomingTasks.setAdapter(taskAdapter);
        rvUpcomingTasks.setLayoutManager(new LinearLayoutManager(this));
    }
}
