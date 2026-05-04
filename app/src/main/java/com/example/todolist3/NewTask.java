package com.example.todolist3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class NewTask extends AppCompatActivity {

    EditText editTextTaskTitle;
    Button buttonAttachImage, buttonRecordAudio, buttonSetDeadline, buttonSaveTask;
    TextView textViewCancel;
    ImageView imageViewClose;
    String selectedDeadline = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        editTextTaskTitle = findViewById(R.id.editTextTaskTitle);
        buttonAttachImage = findViewById(R.id.buttonAttachImage);
        buttonRecordAudio = findViewById(R.id.buttonRecordAudio);
        buttonSetDeadline = findViewById(R.id.buttonSetDeadline);
        buttonSaveTask = findViewById(R.id.buttonSaveTask);
        textViewCancel = findViewById(R.id.textViewCancel);
        imageViewClose = findViewById(R.id.imageViewClose);

        imageViewClose.setOnClickListener(v -> finish());
        textViewCancel.setOnClickListener(v -> finish());

        buttonAttachImage.setOnClickListener(v -> {
            Intent takeImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takeImageIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takeImageIntent, 1);
            } else {
                Toast.makeText(this, "Camera not found", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRecordAudio.setOnClickListener(v -> {
            Intent recordAudioIntent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (recordAudioIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(recordAudioIntent, 2);
            } else {
                Toast.makeText(this, "Audio recorder not found", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSetDeadline.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        selectedDeadline = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        buttonSetDeadline.setText("Deadline: " + selectedDeadline);
                    }, year, month, day);
            datePickerDialog.show();
        });

        buttonSaveTask.setOnClickListener(v -> {
            String title = editTextTaskTitle.getText().toString();
            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter a task title", Toast.LENGTH_SHORT).show();
            } else {
                LandingPage.tasks.add(new Task(title, selectedDeadline));
                Toast.makeText(this, "Task saved!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}