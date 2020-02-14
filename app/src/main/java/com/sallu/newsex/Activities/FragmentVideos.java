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
import androidx.room.Database;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sallu.newsex.Adapters.AdapterForBreakingNews;
import com.sallu.newsex.Adapters.AdapterForTrendingPage;
import com.sallu.newsex.Adapters.AdapterForVideos;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.Database.Video;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.ModelClass.VideosModelClass;
import com.sallu.newsex.R;
import com.sallu.newsex.Utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentVideos extends Fragment implements  AdapterForVideos.onNoteListener{

    RecyclerView recyclerView;
    AdapterForVideos adapter;
    List<Video> list ;
    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_videos, container, false);
        Logger.addLogAdapter(new AndroidLogAdapter());
        recyclerView = rootView.findViewById(R.id.videoRecyclerView);
        list = DatabaseCall.getVideos(MyAppDatabase.getAppDatabase(getContext()));




        if (list.size() == 0){
           // warning.setVisibility(View.VISIBLE);
        }else {

            adapter =new AdapterForVideos(getContext(),list,this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
        }



    /*    recyclerView.addOnItemTouchListener(new RecyclerTouchListener(rootView.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent=new Intent(rootView.getContext(),VideoPlayerActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
 */
        return rootView;
    }


    @Override
    public void onNoteClicked(int position) {

    }
}
