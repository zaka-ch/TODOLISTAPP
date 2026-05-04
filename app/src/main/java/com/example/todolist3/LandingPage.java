package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class LandingPage extends AppCompatActivity {

    RecyclerView rvTasks;
    Button addButton;
    BottomNavigationView bottomNavigationView;
    public static List<Task> tasks = new ArrayList<>();
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);

        rvTasks = findViewById(R.id.rvTasks);
        addButton = findViewById(R.id.Button);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if (tasks.isEmpty()) {
            tasks.add(new Task("Wake up"));
            tasks.add(new Task("Go to gym"));
            tasks.add(new Task("Sleep"));
        }

        taskAdapter = new TaskAdapter(tasks, this);
        rvTasks.setAdapter(taskAdapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        addButton.setOnClickListener(v -> {
            startActivity(new Intent(LandingPage.this, NewTask.class));
        });

        /// NAVBAR Landing page
        bottomNavigationView.setSelectedItemId(R.id.navigation_tasks);

        bottomNavigationView.setOnItemSelectedListener(MenuItem -> {
            int id = MenuItem.getItemId();

            if(id == R.id.navigation_tasks){
                return true;
            } else if (id == R.id.navigation_upcoming) {
                startActivity(new Intent(LandingPage.this, UpcomingPage.class));
                return true;
            } else if (id == R.id.navigation_settings) {
                startActivity(new Intent(LandingPage.this, SettingsPage.class));
                return true;
            }

            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (taskAdapter != null) {
            taskAdapter.notifyDataSetChanged();
            rvTasks.scrollToPosition(tasks.size() - 1);
        }
    }
}
