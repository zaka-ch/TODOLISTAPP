package com.example.todolist3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        Log.d("lifecycle", "on create executed");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword2);
        loginButton = findViewById(R.id.LoginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = username.getText().toString();
                String p = password.getText().toString();

                if(n.isEmpty() || p.isEmpty()){
                    Toast.makeText(MainActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    if (!n.equals("admin")) { 
                        Toast.makeText(MainActivity.this, "the username is wrong", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!p.equals("admin")) {
                            Toast.makeText(MainActivity.this, "the password is wrong", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(MainActivity.this, LandingPage.class);
                            startActivity(intent);
                            finish(); 
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle" ,"On pause Executed" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle" ,"On resume Executed" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle" ,"On start Executed" );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle" ,"On stop Executed" );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle" ,"On restart Executed" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle" ,"On destroy Executed" );
    }
}