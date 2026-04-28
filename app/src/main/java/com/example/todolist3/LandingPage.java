package com.example.todolist3;
import androidx.core.content.ContextCompat;
import android.graphics.Color;
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


            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );



            params.setMargins(100, 40, 0, 0);

            LinearLayout row = new LinearLayout(this);
            CheckBox NewCheckBox = new CheckBox(this);
            Button delete = new Button(this);
            Button edit = new Button(this);

            row.setPadding(40, 25, 40, 25);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setBackgroundResource(R.drawable.task_background);
            row.setLayoutParams(params);


            NewCheckBox.setText("TestTask");
            NewCheckBox.setTextColor(ContextCompat.getColor(this, R.color.onPrimary));
            NewCheckBox.setPadding(10, 0, 0, 0);
            NewCheckBox.setTextSize(18);
            NewCheckBox.setTypeface(null, android.graphics.Typeface.BOLD);

            delete.setText("X");
            delete.setTextSize(30);
            delete.setTextColor(ContextCompat.getColor(this, R.color.error));
            delete.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            delete.setOnClickListener(del -> TaskContainer.removeView(row));
            edit.setText("EDIT");
            edit.setTextSize(14);
            edit.setTextColor(ContextCompat.getColor(this, R.color.onPrimary));
            edit.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            edit.setTypeface(null, android.graphics.Typeface.BOLD);

            edit.setOnClickListener(editing -> {
                AlertDialog.Builder editTab = new AlertDialog.Builder(this);

                editTab.setTitle("Edit Task");
                EditText input = new EditText(this);
                input.setText(NewCheckBox.getText());
                editTab.setView(input);
                editTab.setPositiveButton("Save", (dialog, which) -> {
                    NewCheckBox.setText(input.getText().toString());
                });

                editTab.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                editTab.show();
            });


            row.addView(NewCheckBox);
            row.addView(edit);
            row.addView(delete);
            TaskContainer.addView(row);
        });
    }

}
