package com.denis.cobafragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticleFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = 0;

    private ArrayList<String> listHeadline = new ArrayList<>();
    private ArrayList<String> listArticle = new ArrayList<>();
    private ArrayList<String> listImage = new ArrayList<>();

    private TextView txtArticle;
    private TextView txtHeadline;
    private ImageView image;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        view = inflater.inflate(R.layout.article_view, container, false);
        txtHeadline = view.findViewById(R.id.article_title);
        txtArticle = view.findViewById(R.id.article_content);
        image = view.findViewById(R.id.article_img);
        listImage.addAll(Arrays.asList(getResources().getStringArray(R.array.image)));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void updateArticleView(int position, ArrayList<String> listArticle, ArrayList<String> listHeadline, ArrayList<String> listImage) {
        txtHeadline.setText(listHeadline.get(position));
        txtArticle.setText(listArticle.get(position));
        Picasso.get().load(listImage.get(position)).fit().centerCrop().into(image);

        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
