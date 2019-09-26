package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sallu.newsex.Database.Categories;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.Network.ApiCall;
import com.sallu.newsex.Network.CategoryModelClass;
import com.sallu.newsex.Network.DateModelClass;
import com.sallu.newsex.Network.RetrofitApiClient;
import com.sallu.newsex.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Logger.addLogAdapter(new AndroidLogAdapter());

        addDataFromServer();
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        startActivity(intent);




    }

    public  void addDataFromServer(){



        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);

        Call<DateModelClass> call = apiCall.getDates();

        call.enqueue(new Callback<DateModelClass>() {
            @Override
            public void onResponse(Call<DateModelClass> call, Response<DateModelClass> response) {

                DateModelClass dateModelClass = response.body();

                if (response.code() == 200){
                    List<DateModelClass.Datum> list = dateModelClass.getData();

                    for (DateModelClass.Datum data: list){

                        Logger.d(data);

                    }
                }

            }

            @Override
            public void onFailure(Call<DateModelClass> call, Throwable t) {

            }
        });

/*
        Call<CategoryModelClass> call = apiCall.getData();

        call.enqueue(new Callback<CategoryModelClass>() {
            @Override
            public void onResponse(Call<CategoryModelClass> call, Response<CategoryModelClass> response) {
                CategoryModelClass mClass = response.body();

                if (response.code() == 200){

                    List<CategoryModelClass.Category> list = mClass.getCategories();
                    int netUser = DatabaseCall.getDataSetNumber(MyAppDatabase.getAppDatabase(getApplicationContext()));

                    Logger.d("total user : " + netUser);
                    Logger.d("List size : "+list.size());

                    if (list.size() > netUser){

                        DatabaseCall.deleteData(MyAppDatabase.getAppDatabase(getApplicationContext()));

                        for (CategoryModelClass.Category categoryModelClass : list){
                            int id = categoryModelClass.getId();
                            String categoryname = categoryModelClass.getName();

                            Categories categories = new Categories();
                            categories.setId(id);
                            categories.setCategory(categoryname);
                            DatabaseCall.addData(MyAppDatabase.getAppDatabase(getApplicationContext()),categories);
                        }

                        Intent intent = new Intent(StartActivity.this,MainActivity.class);
                        startActivity(intent);

                    }else if(list.size() == netUser){
                        Intent intent = new Intent(StartActivity.this,MainActivity.class);
                        startActivity(intent);

                    }
                }

            }

            @Override
            public void onFailure(Call<CategoryModelClass> call, Throwable t) {

                Logger.d("problem " + t.getMessage());

            }
        });
    } */

}}
