package com.sallu.newsex.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sallu.newsex.Adapters.AdapterForTrendingPage;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentTrending extends Fragment {

    RecyclerView recyclerView;
    AdapterForTrendingPage adapter;
    List<TrendingModelClass> list =new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trending, container, false);
        recyclerView = rootView.findViewById(R.id.trendingRecyclerView);
        adapter =new AdapterForTrendingPage(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        addData();


        return rootView;
    }

    private void addData() {

        TrendingModelClass data = new TrendingModelClass(R.drawable.image,
                "Dengue kills 5 people in dhaka",
                "Staff Reporter,Dhaka");
        list.add(data);

        TrendingModelClass data1=new TrendingModelClass(R.drawable.imagetwo,"Mia Khalifa is going to marry you",
                "staff reporter,Africa");
        list.add(data1);

    }
}
