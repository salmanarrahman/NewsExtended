package com.sallu.newsex.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    //https://api.myjson.com/bins/1e27tp
    @GET("1e27tp")
    Call<CategoryModelClass> getData();

    @GET("newsex/readDate.php")
    Call<DateModelClass> getDates();





}
