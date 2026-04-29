package com.example.todolist3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class AddTask extends AppCompatActivity {

    private String StringTitle,StringDeadLine;


    ImageButton Close;
    EditText Title;
    LinearLayout AddImage;
    LinearLayout RecordAudio;
    LinearLayout SetDeadLine;

    Button Save;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        Close = findViewById(R.id.Close);
        Title = findViewById(R.id.inputTaskTitle);
        AddImage = findViewById(R.id.AddImage);
        RecordAudio = findViewById(R.id.RecordAudio);
        SetDeadLine = findViewById(R.id.SetDeadLine);
        Save = findViewById(R.id.Save);


        Close.setOnClickListener(close -> finish());

        SetDeadLine.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, day) -> {
                StringDeadLine = day + "/" + (month + 1) + "/" + year;
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
        });


        Save.setOnClickListener(Save -> {

            StringTitle = Title.getText().toString();
            if(StringTitle.isEmpty()){
                Title.setError("Must Set Title");
                return;
            }
            Intent result = new Intent();
            result.putExtra("taskTitle", getTaskTitle());
            result.putExtra("taskDeadline", getTaskDeadLine());
            setResult(RESULT_OK, result);
            finish();

        });




        }

    public String getTaskTitle(){
        return StringTitle;
    }
    public String getTaskDeadLine(){
        return StringDeadLine;
    }
}

