    package com.example.todolist3;
    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.LinearLayout;
    import android.widget.TextView;
    import androidx.activity.result.ActivityResultLauncher;
    import androidx.activity.result.contract.ActivityResultContracts;
    import androidx.appcompat.app.AppCompatActivity;
    import com.google.android.material.bottomnavigation.BottomNavigationView;


    public class LandingPage extends AppCompatActivity {

        Button addButton;
        BottomNavigationView bottomNavigationView;
        LinearLayout taskContainer;


        // Replaces startActivityForResult (which is deprecated)
        private final ActivityResultLauncher<Intent> addTaskLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();

                        // This is where the two getters' values arrive
                        String title    = data.getStringExtra("taskTitle");
                        String deadline = data.getStringExtra("taskDeadline");

                        addTaskToList(title, deadline);
                    }
                });



        @SuppressLint({"SetTextI18n", "ResourceAsColor"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.landing);
            addButton = findViewById(R.id.AddButton);
            bottomNavigationView = findViewById(R.id.bottomNavigationView);
            bottomNavigationView.setSelectedItemId(R.id.navigation_tasks);
            taskContainer = findViewById(R.id.TasksContainer);


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
                addTaskLauncher.launch(new Intent(LandingPage.this, AddTask.class));
            });
        }

        @SuppressLint("SetTextI18n")
        private void addTaskToList(String title, String deadline) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setPadding(16, 16, 16, 16);
            row.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));

            CheckBox checkBox = new CheckBox(this);

            TextView taskView = new TextView(this);
            taskView.setText(title + (deadline != null && !deadline.isEmpty() ? "  •  " + deadline : ""));
            taskView.setTextSize(16);

            Button deleteBtn = new Button(this);
            deleteBtn.setText("Delete");

            deleteBtn.setOnClickListener(v -> {
                taskContainer.removeView(row);
            });

            row.addView(checkBox);
            row.addView(taskView);
            row.addView(deleteBtn);

            taskContainer.addView(row);
        }

    }
