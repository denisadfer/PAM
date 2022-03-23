package com.denis.cobafragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;
import java.util.ArrayList;
import java.util.Arrays;

public class HeadlinesFragment extends ListFragment {

    private ArrayList<String> listHeadline = new ArrayList<>();
    private ArrayList<String> listArticle = new ArrayList<>();
    private ArrayList<String> listImage = new ArrayList<>();
    private ArrayList<String> listNews = new ArrayList<>();

    OnHeadlineSelectedListener mCallBack;
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position,  ArrayList<String> listArticle, ArrayList<String> listHeadline, ArrayList<String> listImage);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHeadline.addAll(Arrays.asList(getResources().getStringArray(R.array.headlines)));
        listArticle.addAll(Arrays.asList(getResources().getStringArray(R.array.articles)));
        listImage.addAll(Arrays.asList(getResources().getStringArray(R.array.image)));
        for (int i=0;i<listHeadline.size();i++) {
            listNews.add(listHeadline.get(i).substring(0, 10) + "..." + "\n" + listArticle.get(i).substring(0, 30) + "...");
        }
        int layout;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            layout = android.R.layout.simple_list_item_activated_1;
        } else {
            layout = android.R.layout.simple_list_item_1;
        }
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, listNews));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallBack.onArticleSelected(position, listArticle, listHeadline, listImage);
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.articles_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
}
