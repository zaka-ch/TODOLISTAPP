package com.example.todolist3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todolist3.R;

public class AddTaskActivity extends AppCompatActivity {

    EditText etTaskTitle;
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Log.d("lifecycle", "on create executed");

        etTaskTitle = findViewById(R.id.et_task_title);
        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);

        btnSave.setOnClickListener(v -> {
            String title = etTaskTitle.getText().toString();
            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter a task title", Toast.LENGTH_SHORT).show();
            } else {
                Intent result = new Intent();
                result.putExtra("task_title", title);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        btnCancel.setOnClickListener(v -> finish());
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
