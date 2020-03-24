package com.sallu.newsex.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sallu.newsex.Adapters.AdapterForBreakingNews;
import com.sallu.newsex.Database.BreakingNews;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.R;

import java.util.List;

public class FragmentBrakingNews extends Fragment implements AdapterForBreakingNews.onNoteListener{

    RecyclerView recyclerView;
    AdapterForBreakingNews adapter;
 //   List<BreakingNews> listOne =new ArrayList<>();
      List<BreakingNews> list;
    View rootView;
    TextView warning;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_braking_news, container, false);
        warning = rootView.findViewById(R.id.errorText);
        recyclerView = rootView.findViewById(R.id.breakingNewsRecyclerView);
        Logger.addLogAdapter(new AndroidLogAdapter());
        warning.setVisibility(View.INVISIBLE);



        list = DatabaseCall.getBreakingNews(MyAppDatabase.getAppDatabase(getContext()));

        if (list.size() == 0){
            warning.setVisibility(View.VISIBLE);
        }else {

            adapter = new AdapterForBreakingNews(this, getContext(), list);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            //     recyclerView.addItemDecoration(new DividerItemDecoration(rootView.getContext(), LinearLayoutManager.VERTICAL));
            recyclerView.setAdapter(adapter);
        }






        return rootView;
    }

    @Override
    public void onNoteClicked(int position) {

        BreakingNews li = list.get(position);
        Logger.d(li.getHeadline());

        String imageSource = li.getThumbnail();
        String headline = li.getHeadline();
        String news = li.getNews();
        String retporter = li.getReporter();




        Intent intent = new Intent(getActivity(),FullNewsActivity.class);
        intent.putExtra("image",imageSource);
        intent.putExtra("headline",headline);
        intent.putExtra("news",news);
        intent.putExtra("reporter",retporter);
        startActivity(intent);

        Toast.makeText(getContext(),"cliecked " + position ,Toast.LENGTH_SHORT).show();

    }

}
