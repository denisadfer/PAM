package com.denis.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    protected EditText editTextUsername, editTextPassword;
    protected Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void login(View v) {
        Context context = getApplicationContext();
        CharSequence text = "This Field is Required";
        CharSequence un = "Username Do Not Match";
        CharSequence pw = "Password Do Not Match";
        int duration = Toast.LENGTH_SHORT;
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        Intent intent = getIntent();
        String uname = intent.getStringExtra("username");
        String pass = intent.getStringExtra("password");
        String fullname = intent.getStringExtra("fullname");

        if (username.length()==0){
            editTextUsername.setError(text);
        } else if (password.length()==0) {
            editTextUsername.setError(text);
        } else if (!username.equals(uname)) {
            Toast toast = Toast.makeText(context, un, duration);
            toast.show();
        } else if (!password.equals(pass)) {
            Toast toast = Toast.makeText(context, pw, duration);
            toast.show();
        } else {
            Intent intent1 = new Intent(this, WelcomeActivity.class);
            intent1.putExtra("fullname",fullname);
            startActivity(intent1);
        }
    }
}