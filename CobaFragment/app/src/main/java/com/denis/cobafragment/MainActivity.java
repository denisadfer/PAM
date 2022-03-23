package com.denis.cobafragment;


import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements
        HeadlinesFragment.OnHeadlineSelectedListener {

    private List<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onArticleSelected(int position, ArrayList<String> listArticle,  ArrayList<String> listHeadline,ArrayList<String> listImage) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.articles_fragment);
        articleFragment.updateArticleView(position, listArticle, listHeadline, listImage);
    }

    public void addNew(View v) {
        Intent intent = new Intent(this, AddNew.class);
        startActivity(intent);
    }

}