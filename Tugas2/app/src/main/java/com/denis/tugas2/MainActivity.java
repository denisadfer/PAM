package com.denis.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText editTextUsername, editTextFullName, editTextPassword, editTextConfirmPassword;
    protected Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        btnRegis = findViewById(R.id.btnRegis);
    }

    public void register(View v) {
        Context context = getApplicationContext();
        CharSequence text = "This Field is required";
        CharSequence validation = "Password Do Not Match";
        int duration = Toast.LENGTH_SHORT;
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        if (editTextUsername.getText().toString().length()==0){
            editTextUsername.setError(text);
        } else if (editTextFullName.getText().toString().length()==0) {
            editTextFullName.setError(text);
        } else if (editTextPassword.getText().toString().length()==0) {
            editTextPassword.setError(text);
        } else if (editTextConfirmPassword.getText().toString().length()==0) {
            editTextConfirmPassword.setError(text);
        } else if (!confirmPassword.equals(password)){
            Toast toast = Toast.makeText(context, validation, duration);
            toast.show();
        } else {
            String username = editTextUsername.getText().toString();
            String fullname = editTextFullName.getText().toString();

            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("password",password);
            intent.putExtra("fullname",fullname);
            startActivity(intent);
        }
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