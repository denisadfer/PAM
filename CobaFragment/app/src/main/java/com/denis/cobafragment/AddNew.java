package com.denis.cobafragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class AddNew extends AppCompatActivity {

    private ArrayList<String> listHeadline = new ArrayList<>();
    private ArrayList<String> listArticle = new ArrayList<>();
    private ArrayList<String> listImage = new ArrayList<>();
    protected EditText editTextHeadline, editTextArticle, editTextImage;
    protected Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        editTextHeadline = findViewById(R.id.editTextHeadline);
        editTextArticle = findViewById(R.id.editTextArticle);
        editTextImage = findViewById(R.id.editTextImage);
        btnAdd = findViewById(R.id.btnAdd);
    }

    public void done(View v) {
        Context context = getApplicationContext();
        CharSequence text = "This Field is required";
        String headline = editTextHeadline.getText().toString();
        String article = editTextArticle.getText().toString();
        String image = editTextImage.getText().toString();

        if (headline.length()==0){
            editTextHeadline.setError(text);
        } else if (article.length()==0){
            editTextArticle.setError(text);
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            listHeadline.addAll(Arrays.asList(getResources().getStringArray(R.array.headlines)));
            listArticle.addAll(Arrays.asList(getResources().getStringArray(R.array.articles)));
            listImage.addAll(Arrays.asList(getResources().getStringArray(R.array.image)));
            listHeadline.add(headline);
            listArticle.add(article);
            listImage.add(image);
            startActivity(intent);
        }
    }
}