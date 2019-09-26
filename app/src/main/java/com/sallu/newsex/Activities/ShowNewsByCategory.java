package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.sallu.newsex.Adapters.AdapterForBreakingNews;
import com.sallu.newsex.Adapters.AdapterForCategoryNews;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.CategorywiseNewsModelClass;
import com.sallu.newsex.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ShowNewsByCategory extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterForCategoryNews adapter;
    List<CategorywiseNewsModelClass> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news_by_category);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        recyclerView = findViewById(R.id.newsCategoryRecyclerView);
        adapter =new AdapterForCategoryNews(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //     recyclerView.addItemDecoration(new DividerItemDecoration(rootView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        addData();


    }

    private void addData() {

        CategorywiseNewsModelClass data = new CategorywiseNewsModelClass(R.drawable.bnp,
                "Category Wise Newss",
                "barishal");
        list.add(data);
        CategorywiseNewsModelClass data1 = new CategorywiseNewsModelClass(R.drawable.image,
                "Category Wise Newss",
                "khulna");
        list.add(data1);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
