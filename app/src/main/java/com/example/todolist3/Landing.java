package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Landing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button addBtn = findViewById(R.id.button2);
        addBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, NewTask.class));
        });
    }
}