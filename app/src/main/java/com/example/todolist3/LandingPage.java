package com.example.todolist3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class LandingPage extends AppCompatActivity {

    LinearLayout TaskContainer;
    ImageButton addButton;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);

        TaskContainer = findViewById(R.id.TasksContainer);
        addButton = findViewById(R.id.AddTaskButton);


        addButton.setOnClickListener(v -> {
            CheckBox NewCheckBox = new CheckBox(this);
            NewCheckBox.setText("TestTask");

            TaskContainer.addView(NewCheckBox);
        });
    }

}
