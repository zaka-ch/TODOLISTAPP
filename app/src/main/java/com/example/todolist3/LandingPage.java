package com.example.todolist3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LandingPage extends AppCompatActivity {

    LinearLayout TaskContainer;
    Button addButton;
    BottomNavigationView bottomNavigationView;




    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);

        TaskContainer = findViewById(R.id.TasksContainer);
        addButton = findViewById(R.id.Button);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

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



        addButton.setOnClickListener(v -> {

            LinearLayout row = new LinearLayout(this);
            row.setPadding(16,16,16,16);
            CheckBox NewCheckBox = new CheckBox(this);
            Button delete = new Button(this);
            Button edit = new Button(this);


            NewCheckBox.setText("TestTask");
            delete.setText("X");
            delete.setTextColor(R.color.red);
            delete.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            delete.setOnClickListener(del -> TaskContainer.removeView(row));
            edit.setText("Edit");
            delete.setTextColor(R.color.blue);
            edit.setBackgroundColor(android.graphics.Color.TRANSPARENT);

            edit.setOnClickListener(editing -> {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Edit Task");

                EditText input = new EditText(this);
                input.setText(NewCheckBox.getText());
                builder.setView(input);

                builder.setPositiveButton("Save", (dialog, which) -> {
                    NewCheckBox.setText(input.getText().toString());
                });

                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

                builder.show();
            });


            row.addView(NewCheckBox);
            row.addView(delete);
            row.addView(edit);
            TaskContainer.addView(row);
        });
    }

}
