package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.sallu.newsex.Adapters.AdapterForBreakingNews;
import com.sallu.newsex.Adapters.AdapterForCategoryNews;
import com.sallu.newsex.Database.CategorywiseNews;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.Database.TrendingNews;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.CategorywiseNewsModelClass;
import com.sallu.newsex.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ShowNewsByCategory extends AppCompatActivity implements AdapterForCategoryNews.onNoteListener{

    RecyclerView recyclerView;
    AdapterForCategoryNews adapter;
    List<CategorywiseNews> list;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news_by_category);
        Logger.addLogAdapter(new AndroidLogAdapter());
        recyclerView = findViewById(R.id.newsCategoryRecyclerView);
        text = findViewById(R.id.warningMessageOne);
        text.setVisibility(View.INVISIBLE);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Bundle bundle = getIntent().getExtras();
        String id= bundle.getString("id");
        Logger.d("cached "+id);


         list = DatabaseCall
                .getCategorywiseNewsByCategory(MyAppDatabase.getAppDatabase(getApplicationContext()),id);
         if (list.size() == 0){
             text.setVisibility(View.VISIBLE);
         }else {
             adapter =new AdapterForCategoryNews(this,getApplicationContext(),list);
             RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
             recyclerView.setLayoutManager(mLayoutManager);
             recyclerView.setItemAnimator(new DefaultItemAnimator());
             recyclerView.setAdapter(adapter);
         }





    }


    @Override
    public void onNoteClicked(int position) {
        CategorywiseNews li = list.get(position);
        Logger.d(li.getHeadline());

        String imageSource = li.getThumbnail();
        String headline = li.getHeadline();
        String news = li.getNews();
        String retporter = li.getReporter();




        Intent intent = new Intent(getApplicationContext(),FullNewsActivity.class);
        intent.putExtra("image",imageSource);
        intent.putExtra("headline",headline);
        intent.putExtra("news",news);
        intent.putExtra("reporter",retporter);
        startActivity(intent);
    }
}
