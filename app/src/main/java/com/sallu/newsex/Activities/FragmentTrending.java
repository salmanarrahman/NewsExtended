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
import com.sallu.newsex.Adapters.AdapterForTrendingPage;
import com.sallu.newsex.Database.BreakingNews;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.Database.TrendingNews;
import com.sallu.newsex.ModelClass.SendDaterequest;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.Network.ApiCall;
import com.sallu.newsex.Network.RetrofitApiClient;
import com.sallu.newsex.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTrending extends Fragment implements AdapterForTrendingPage.onNoteListener{

    RecyclerView recyclerView;
    AdapterForTrendingPage adapter;
    View rootView;
    List<TrendingNews> list;
    TextView warningMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_trending, container, false);
        Logger.addLogAdapter(new AndroidLogAdapter());
        recyclerView = rootView.findViewById(R.id.trendingRecyclerView);
        warningMessage = rootView.findViewById(R.id.warningMessage);
        warningMessage.setVisibility(View.INVISIBLE);



         list = DatabaseCall.getTrendingNews(MyAppDatabase.getAppDatabase(getContext()));

         if (list.size() == 0){
             warningMessage.setVisibility(View.VISIBLE);
         }else {

             adapter = new AdapterForTrendingPage(this, getContext(), list);
             RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
             recyclerView.setLayoutManager(mLayoutManager);
             recyclerView.setItemAnimator(new DefaultItemAnimator());
             recyclerView.setAdapter(adapter);
         }


        return rootView;
    }

    @Override
    public void onNoteClicked(int position) {

        TrendingNews li = list.get(position);
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
