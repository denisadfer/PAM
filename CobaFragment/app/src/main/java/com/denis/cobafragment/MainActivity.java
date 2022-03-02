package com.denis.cobafragment;


import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
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

    public void onArticleSelected(int position, ArrayList<String> listArticles, ArrayList<String> listHeadline) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.articles_fragment);
        articleFragment.updateArticleView(position, listArticles, listHeadline);
    }
}