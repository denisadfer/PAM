
package com.denis.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textWelcome = findViewById(R.id.textWelcome);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        textWelcome.setText("Welcome, "+username);


    }
}