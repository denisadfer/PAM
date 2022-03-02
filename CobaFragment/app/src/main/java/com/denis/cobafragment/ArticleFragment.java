package com.denis.cobafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ArticleFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = 0;

    private ArrayList<String> listHeadline = new ArrayList<>();
    private ArrayList<String> listArticle = new ArrayList<>();

    private TextView txtArticle;
    private TextView txtHeadline;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        view = inflater.inflate(R.layout.article_view, container, false);
        txtArticle = view.findViewById(R.id.article_content);
        txtHeadline = view.findViewById(R.id.article_title);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if(args != null) {
//            updateArticleView(args.getInt(ARG_POSITION));
//            cl = args.getStringArrayList(ARG)
        }
//        else {
//            updateArticleView(mCurrentPosition);
//        }
    }

    public void updateArticleView(int position, ArrayList<String> listArticle, ArrayList<String> listHeadline) {
        txtHeadline.setText(listHeadline.get(position));
        txtArticle.setText(listArticle.get(position));

        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
