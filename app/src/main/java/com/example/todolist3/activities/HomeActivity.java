package com.example.todolist3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist3.R;
import com.example.todolist3.adapters.TaskAdapter;
import com.example.todolist3.structures.Task;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnAddTask, btnLogout;
    RecyclerView rvTasks;
    List<Task> tasks;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("lifecycle", "on create executed");

        tvWelcome = findViewById(R.id.tv_welcome);
        btnAddTask = findViewById(R.id.btn_add_task);
        btnLogout = findViewById(R.id.btn_logout);
        rvTasks = findViewById(R.id.rv_tasks);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        tvWelcome.setText("Welcome " + username);

        tasks = new ArrayList<>();
        tasks.add(new Task("Wake up"));
        tasks.add(new Task("Go to gym"));
        tasks.add(new Task("Sleep"));

        taskAdapter = new TaskAdapter(tasks);
        rvTasks.setAdapter(taskAdapter);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        btnAddTask.setOnClickListener(v -> {
            startActivityForResult(new Intent(HomeActivity.this, AddTaskActivity.class), 1);
        });

        btnLogout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(HomeActivity.this, MainActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(logoutIntent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("task_title");
            if (title != null && !title.isEmpty()) {
                tasks.add(new Task(title));
                taskAdapter.notifyItemInserted(tasks.size() - 1);
                rvTasks.scrollToPosition(tasks.size() - 1);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "On pause Executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "On resume Executed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "On start Executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "On stop Executed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "On restart Executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "On destroy Executed");
    }
}
