package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sallu.newsex.Adapters.AdapterForDialogue;
import com.sallu.newsex.Database.BreakingNews;
import com.sallu.newsex.Database.Categories;
import com.sallu.newsex.Database.CategorywiseNews;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.Dates;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.Database.TrendingNews;
import com.sallu.newsex.Database.Video;
import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.CategoryModelClass;
import com.sallu.newsex.ModelClass.CategorywiseNewsModelClass;
import com.sallu.newsex.ModelClass.SendDaterequest;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.ModelClass.VideosModelClass;
import com.sallu.newsex.Network.ApiCall;
import com.sallu.newsex.ModelClass.DateModelClass;
import com.sallu.newsex.Network.RetrofitApiClient;
import com.sallu.newsex.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartActivity extends AppCompatActivity implements AdapterForDialogue.onNoteListener {

    LayoutInflater inflater;
    Button aButton;
    Boolean firstRun;
    RecyclerView recyclerView;
    List<Dates> listOne;
    AdapterForDialogue adapter;
    int dateid;
    String formattedDate;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

       // permissions();
        Fabric.with(this, new Crashlytics());
    //  Crashlytics.getInstance().crash();
        Logger.addLogAdapter(new AndroidLogAdapter());
        //shared preferences
        firstRun = getSharedPreferences("preference",MODE_PRIVATE).
                getBoolean("isFirstRun",true);

        listOne = DatabaseCall.getDates(MyAppDatabase.getAppDatabase(getApplicationContext()));
        //getting the time
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = df.format(c);

        List<Video> videoList = DatabaseCall.getVideos(MyAppDatabase.getAppDatabase(getApplicationContext()));
        if (videoList.size()>0){
            DatabaseCall.deleteVideos(MyAppDatabase.getAppDatabase(getApplicationContext()));
        }


        Logger.d("Date is  "+formattedDate);

        try {

            dateid = DatabaseCall.getDateIDstring(MyAppDatabase.getAppDatabase(getApplicationContext()), formattedDate);
            Logger.d("The date id is " + dateid);
        }catch (Exception e){
            Logger.d(e.getMessage());
        }




        if (!isConnected()){
            Intent intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
        }else {

            if (dateid == 0) {
                customDialogue();
            } else {

                if (firstRun == true) {
                    //  Toast.makeText(getApplicationContext(), "first time", Toast.LENGTH_SHORT).show();

                    //addVideosData();
                    addDataFromServer();
                    addTrendingNews();
                    addBreakingNews();
                    addCategorywiseNews();


                    getSharedPreferences("preference", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();
                } else {

                    DatabaseCall.deleteFromBreakingNews(MyAppDatabase.getAppDatabase(getApplicationContext()));
                    DatabaseCall.deleteFromTrendingnNews(MyAppDatabase.getAppDatabase(getApplicationContext()));
                    DatabaseCall.deleteFromCAtegorywiseNews(MyAppDatabase.getAppDatabase(getApplicationContext()));
                    DatabaseCall.deleteFromDates(MyAppDatabase.getAppDatabase(getApplicationContext()));


                    //addVideosData();
                    addDataFromServer();
                    addTrendingNews();
                    addBreakingNews();
                    addCategorywiseNews();


                }


            }
        }


    }



    public void customDialogue(){

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(StartActivity.this);
        inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialoglayout, null);
        builder.setView(dialogView);
//        aButton = dialogView.findViewById(R.id.copyButton);
        recyclerView = dialogView.findViewById(R.id.recyclerViewForDate);

         alertDialog = builder.create();
        alertDialog.setCancelable(false);
        adapter =new AdapterForDialogue(this,getApplicationContext(), listOne);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        alertDialog.show();


    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.d("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

  /*  private void addVideosData() {

        Logger.d("Executing video method");

        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);
        Call<VideosModelClass> call = apiCall.getVideoData(new SendDaterequest(dateid));
        Logger.d(dateid);
        call.enqueue(new Callback<VideosModelClass>() {
            @Override
            public void onResponse(Call<VideosModelClass> call, Response<VideosModelClass> response) {
                VideosModelClass modelClass = response.body();

                if (response.code() == 200){

                    if (response.code() == 200){
                        Logger.d("succsss");
                        List<VideosModelClass.Video> list = modelClass.getVideos();

                        for (VideosModelClass.Video data: list){
                            try {
                        // DatabaseCall.deleteFromDates(MyAppDatabase.getAppDatabase(getApplicationContext()));
                                Video video = new Video();
                                video.setDateid(data.getDateid());
                                video.setVideoid(data.getId());
                                video.setVideoaddress(data.getVideoaddress());
                                video.setCameraman(data.getCameraman());
                                video.setTitle(data.getTitle());
                                video.setNews(data.getNews());
                                video.setThumbnail(data.getThumbnail());
                                DatabaseCall.addVideos(MyAppDatabase.getAppDatabase(getApplicationContext()), video);
                                Logger.d(data.getTitle());
                            }catch (Exception e) {
                                Logger.d(e.getMessage());
                            }


                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<VideosModelClass> call, Throwable t) {
                Logger.d(t.getMessage());

            }
        });

    }*/

    private void addCategorywiseNews() {
        Logger.d("Executing addCategorywiseNews");

        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);

        Call<CategorywiseNewsModelClass> call = apiCall.getCategorywiseNews(new SendDaterequest(dateid));

        call.enqueue(new Callback<CategorywiseNewsModelClass>() {
            @Override
            public void onResponse(Call<CategorywiseNewsModelClass> call, Response<CategorywiseNewsModelClass> response) {
                CategorywiseNewsModelClass categorywiseNewsModelClass = response.body();

                if (response.code() == 200){

                    try {

                        List<CategorywiseNewsModelClass.Datum> list = categorywiseNewsModelClass.getData();

                        for (CategorywiseNewsModelClass.Datum data : list) {

                            CategorywiseNews categorywisenews = new CategorywiseNews();
                            categorywisenews.setCategoryid(data.getCategoryid());
                            categorywisenews.setDateid(data.getDateid());
                            categorywisenews.setNewsid(data.getId());
                            categorywisenews.setHeadline(data.getHeadline());
                            categorywisenews.setNews(data.getNews());
                            categorywisenews.setReporter(data.getReporter());
                            categorywisenews.setThumbnail(data.getThumbnail());


                            try {
                                DatabaseCall.addCategorywiseNews(MyAppDatabase.getAppDatabase(getApplicationContext()), categorywisenews);
                            } catch (Exception e) {
                                Logger.d(e.getMessage());
                            }

                        }
                    }catch (Exception e){
                        Logger.d(e.getMessage());
                    }

                }


            }

            @Override
            public void onFailure(Call<CategorywiseNewsModelClass> call, Throwable t) {

            }
        });




    }

    private void addBreakingNews(){
        Logger.d("Executing breaking news");
        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);
        Call<BreakingnewsModelClass> call = apiCall.getBreakingNews(new SendDaterequest(dateid));

        call.enqueue(new Callback<BreakingnewsModelClass>() {
            @Override
            public void onResponse(Call<BreakingnewsModelClass> call, Response<BreakingnewsModelClass> response) {

                BreakingnewsModelClass breakingnewsModelClass = response.body();

                if (response.code() == 200){
                    List<BreakingnewsModelClass.Datum> list = breakingnewsModelClass.getData();

                    try {

                        for (BreakingnewsModelClass.Datum data : list) {
                            BreakingNews breakingNews = new BreakingNews();
                            breakingNews.setDateid(data.getDateid());
                            breakingNews.setNewsid(data.getId());
                            breakingNews.setHeadline(data.getHeadline());
                            breakingNews.setNews(data.getNews());
                            breakingNews.setReporter(data.getReporter());
                            breakingNews.setThumbnail(data.getThumbnail());
                            try {
                                DatabaseCall.addBreakingNews(MyAppDatabase.getAppDatabase(getApplicationContext()), breakingNews);
                            } catch (Exception e) {
                                Logger.d(e.getMessage());
                            }

                        }
                    }catch (Exception e){
                        Logger.d(e.getMessage());

                    }

                }
            }

            @Override
            public void onFailure(Call<BreakingnewsModelClass> call, Throwable t) {

                Logger.d(t.getMessage());

            }
        });
    }

    private void addTrendingNews() {
        Logger.d("Executing");

        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);
        Call<TrendingModelClass> call = apiCall.getTrendingNews(new SendDaterequest(dateid));


        call.enqueue(new Callback<TrendingModelClass>() {
            @Override
            public void onResponse(Call<TrendingModelClass> call, Response<TrendingModelClass> response) {
                TrendingModelClass trendingModelClass = response.body();

                if (response.code() == 200){

                    try {

                        List<TrendingModelClass.Datum> list = trendingModelClass.getData();
                        for (TrendingModelClass.Datum data : list) {
                            TrendingNews trendingNews = new TrendingNews();
                            trendingNews.setDateid(data.getDateid());
                            trendingNews.setNewsid(data.getId());
                            trendingNews.setHeadline(data.getHeadline());
                            trendingNews.setNews(data.getNews());
                            trendingNews.setReporter(data.getReporter());
                            trendingNews.setThumbnail(data.getThumbnail());

                            try {
                                DatabaseCall.addTrendingNews(MyAppDatabase.getAppDatabase(getApplicationContext()), trendingNews);
                            } catch (Exception e) {
                                Logger.d(e.getMessage());
                            }

                        }
                    }catch (Exception e){
                        Logger.d(e.getMessage());
                    }

                }

            }

            @Override
            public void onFailure(Call<TrendingModelClass> call, Throwable t) {

            }
        });



    }

    private void permissions() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(StartActivity.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 112);
        }

    }
/*
    public void fetchTrendingNews(){

        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);

        SendDaterequest dateid = new SendDaterequest();
        dateid.setDate(27);

        Call<TrendingModelClass> call = apiCall.getTrendingNews(new );
        call.enqueue(new Callback<TrendingModelClass>() {
            @Override
            public void onResponse(Call<TrendingModelClass> call, Response<TrendingModelClass> response) {
                TrendingModelClass trendingModelClass = response.body();
            }

            @Override
            public void onFailure(Call<TrendingModelClass> call, Throwable t) {

            }
        });



    }
 */

    public void addDate(){


        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);

        Call<DateModelClass> call = apiCall.getDates();

        call.enqueue(new Callback<DateModelClass>() {
            @Override
            public void onResponse(Call<DateModelClass> call, Response<DateModelClass> response) {

                DateModelClass dateModelClass = response.body();

                if (response.code() == 200){
                    List<DateModelClass.Datum> list = dateModelClass.getData();

                    for (DateModelClass.Datum data: list){
                        try {
                            // DatabaseCall.deleteFromDates(MyAppDatabase.getAppDatabase(getApplicationContext()));
                            Dates dates = new Dates();
                            dates.setDateid(data.getDateID());
                            dates.setDate(data.getDate());
                            DatabaseCall.addDate(MyAppDatabase.getAppDatabase(getApplicationContext()), dates);
                        }catch (Exception e) {
                            Logger.d(e.getMessage());
                        }


                    }
                }

            }

            @Override
            public void onFailure(Call<DateModelClass> call, Throwable t) {
                   Logger.d("failed" + t.getMessage());
            }
        });

    }

    public  void addDataFromServer(){


        ApiCall apiCall = RetrofitApiClient.getClient().create(ApiCall.class);
        Call<VideosModelClass> call = apiCall.getVideoData(new SendDaterequest(dateid));
        Logger.d(dateid);
        call.enqueue(new Callback<VideosModelClass>() {
            @Override
            public void onResponse(Call<VideosModelClass> call, Response<VideosModelClass> response) {
                VideosModelClass modelClass = response.body();

                if (response.code() == 200){

                    if (response.code() == 200){
                        Logger.d("succsss");
                        List<VideosModelClass.Video> list = modelClass.getVideos();

                        for (VideosModelClass.Video data: list){
                            try {
                                // DatabaseCall.deleteFromDates(MyAppDatabase.getAppDatabase(getApplicationContext()));
                                Video video = new Video();
                                video.setDateid(data.getDateid());
                                video.setVideoid(data.getId());
                                video.setVideoaddress(data.getVideoaddress());
                                video.setCameraman(data.getCameraman());
                                video.setTitle(data.getTitle());
                                video.setNews(data.getNews());
                                video.setThumbnail(data.getThumbnail());
                                DatabaseCall.addVideos(MyAppDatabase.getAppDatabase(getApplicationContext()), video);
                                Logger.d(data.getTitle());
                            }catch (Exception e) {
                                Logger.d(e.getMessage());
                            }


                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<VideosModelClass> call, Throwable t) {
                Logger.d(t.getMessage());

            }
        });


        //Lets do this brother

        Logger.d("Executing addDataFromServer");

        ApiCall apiCall1 = RetrofitApiClient.getClient().create(ApiCall.class);


        Call<CategoryModelClass> callBack1 = apiCall1.getCategory();

        callBack1.enqueue(new Callback<CategoryModelClass>() {
            @Override
            public void onResponse(Call<CategoryModelClass> call, Response<CategoryModelClass> response) {
                CategoryModelClass mClass = response.body();

                if (response.code() == 200){

                    List<CategoryModelClass.Datum> list = mClass.getData();
                    int netUser = DatabaseCall.getCategorySetNumber(MyAppDatabase.getAppDatabase(getApplicationContext()));



              //      if (listOne.size() > netUser){

                        DatabaseCall.deleteData(MyAppDatabase.getAppDatabase(getApplicationContext()));

                        for (CategoryModelClass.Datum categoryModelClass : list){
                            int id = categoryModelClass.getCategoryid();
                            String categoryname = categoryModelClass.getCategory();

                            Categories categories = new Categories();
                            categories.setId(id);
                            categories.setCategory(categoryname);
                            DatabaseCall.addCategory(MyAppDatabase.getAppDatabase(getApplicationContext()),categories);
                        }

                        Intent intent = new Intent(StartActivity.this,MainActivity.class);
                       startActivity(intent);

              /*      }else if(listOne.size() == netUser){
                        Intent intent = new Intent(StartActivity.this,MainActivity.class);
                        startActivity(intent);

                    } */
                }

            }

            @Override
            public void onFailure(Call<CategoryModelClass> call, Throwable t) {

                Logger.d("problem " + t.getMessage());

            }
        });
    }


    @Override
    public void onNoteClicked(int position) {

        Dates listPosition = listOne.get(position);

        int clickedid = listPosition.getDateid();
        dateid = clickedid;

      //  Logger.d("clicked "+dateid);


        DatabaseCall.deleteFromBreakingNews(MyAppDatabase.getAppDatabase(getApplicationContext()));
        DatabaseCall.deleteFromTrendingnNews(MyAppDatabase.getAppDatabase(getApplicationContext()));
        DatabaseCall.deleteFromCAtegorywiseNews(MyAppDatabase.getAppDatabase(getApplicationContext()));
        DatabaseCall.deleteFromCAtegorywiseNews(MyAppDatabase.getAppDatabase(getApplicationContext()));


        addDataFromServer();
        addTrendingNews();
        addBreakingNews();
        addCategorywiseNews();
        alertDialog.dismiss();


    }
}