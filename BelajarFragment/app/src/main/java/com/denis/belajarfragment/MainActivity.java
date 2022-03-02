package com.denis.belajarfragment;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements
        HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.frame_container) != null) {
            if(savedInstanceState != null)
                return;

            HeadlinesFragment headlinesFragment = new HeadlinesFragment();
            headlinesFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_container, headlinesFragment).commit();
        }
    }

    public void onArticleSelected(int position) {
        boolean is_landscape = getApplicationContext().getResources().getBoolean(R.bool.is_landscape);
        if(is_landscape) {
            ArticlesFragment articleFragment = (ArticlesFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.article_fragment);
            articleFragment.updateArticleView(position);
        } else {
            Bundle args = new Bundle();
            args.putInt(ArticlesFragment.ARG_POSITION, position);
            ArticlesFragment newArticleFragment = new ArticlesFragment();
            newArticleFragment.setArguments(args);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.frame_container, newArticleFragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }
}