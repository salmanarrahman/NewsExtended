package com.sallu.newsex.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.Adapters.AdapterForTrendingPage;
import com.sallu.newsex.Adapters.AdapterForVideos;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.ModelClass.VideosModelClass;
import com.sallu.newsex.R;
import com.sallu.newsex.Utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentVideos extends Fragment {

    RecyclerView recyclerView;
    AdapterForVideos adapter;
    List<VideosModelClass> list =new ArrayList<>();
    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_videos, container, false);

        recyclerView = rootView.findViewById(R.id.videoRecyclerView);
        adapter =new AdapterForVideos(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        addData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(rootView.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent=new Intent(rootView.getContext(),VideoPlayerActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return rootView;
    }

    private void addData() {

        VideosModelClass data = new VideosModelClass(R.drawable.image,"10","Hello Brother,congratulations on your fucking success","Khulna");
        list.add(data);

        VideosModelClass data1 = new VideosModelClass(R.drawable.bnp,"10","You gotta be fucking shitting me :/","Khulna");

        list.add(data1);

    }
}
