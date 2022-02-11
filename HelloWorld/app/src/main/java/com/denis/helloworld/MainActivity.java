package com.denis.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected EditText editTextUsername, editTextPassword;
    protected Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void login(View v) {
        //statement
        String username = editTextUsername.getText().toString();

        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}