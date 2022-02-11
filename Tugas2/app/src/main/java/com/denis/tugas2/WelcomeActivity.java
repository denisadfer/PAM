package com.denis.tugas2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textWelcome = findViewById(R.id.textWelcome);

        Intent intent1 = getIntent();
        String fullname = intent1.getStringExtra("fullname");
        textWelcome.setText("Welcome, "+fullname);
    }
}