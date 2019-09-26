package com.sallu.newsex.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.Adapters.AdapterForBreakingNews;
import com.sallu.newsex.Adapters.AdapterForTrendingPage;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.R;
import com.sallu.newsex.Utils.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentBrakingNews extends Fragment {

    RecyclerView recyclerView;
    AdapterForBreakingNews adapter;
    List<BreakingnewsModelClass> list =new ArrayList<>();
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_braking_news, container, false);

        recyclerView = rootView.findViewById(R.id.breakingNewsRecyclerView);
        adapter =new AdapterForBreakingNews(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
   //     recyclerView.addItemDecoration(new DividerItemDecoration(rootView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(rootView.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent=new Intent(rootView.getContext(),FullNewsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        addData();

        return rootView;
    }

    private void addData() {


        BreakingnewsModelClass data = new BreakingnewsModelClass(R.drawable.bnp,
                "BNP Calls hartal for five days.Students become happy",
                "Dhaka");
        list.add(data);

        BreakingnewsModelClass data1=new BreakingnewsModelClass(R.drawable.bnp,
                "Sohan become batman",
                "khulna");
        list.add(data1);


    }
}
