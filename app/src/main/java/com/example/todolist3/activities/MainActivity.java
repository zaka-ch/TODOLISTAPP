package com.example.todolist3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todolist3.R;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "on create executed");

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = etUsername.getText().toString();
                String p = etPassword.getText().toString();

                if (n.isEmpty() || p.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    if (!n.equals("admin")) {
                        Toast.makeText(MainActivity.this, "the username is wrong", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!p.equals("admin")) {
                            Toast.makeText(MainActivity.this, "the password is wrong", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("username", n);
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
