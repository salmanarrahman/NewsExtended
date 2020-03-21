package com.sallu.newsex.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.Logger;
import com.sallu.newsex.Database.DatabaseCall;
import com.sallu.newsex.Database.Dates;
import com.sallu.newsex.Database.MyAppDatabase;
import com.sallu.newsex.ModelClass.DateModelClass;
import com.sallu.newsex.Network.ApiCall;
import com.sallu.newsex.Network.RetrofitApiClient;
import com.sallu.newsex.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstTimeInitActivity extends AppCompatActivity {

    Boolean firstRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_init);
        Logger.addLogAdapter(new AndroidLogAdapter());


        firstRun = getSharedPreferences("preference",MODE_PRIVATE).
                getBoolean("isFirstRun",true);

        if (firstRun){
            Logger.d("first time");

            if (!isConnected()){
                Intent intent=new Intent(FirstTimeInitActivity.this,MainActivity.class);
                startActivity(intent);
            }else{
                addDate();
            }

        }else {
            Logger.d("second time");
            if (!isConnected()){
                Intent intent=new Intent(FirstTimeInitActivity.this,MainActivity.class);
                startActivity(intent);
            }else{
                DatabaseCall.deleteFromDates(MyAppDatabase.getAppDatabase(getApplicationContext()));
                addDate();            }


        }
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
                            Logger.d("Successfully date added");
                            DatabaseCall.addDate(MyAppDatabase.getAppDatabase(getApplicationContext()), dates);
                            getSharedPreferences("preference", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

                            Intent intent = new Intent(FirstTimeInitActivity.this,StartActivity.class);
                            startActivity(intent);

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


}
