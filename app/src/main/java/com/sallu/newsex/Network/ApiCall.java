package com.sallu.newsex.Network;

import com.sallu.newsex.ModelClass.BreakingnewsModelClass;
import com.sallu.newsex.ModelClass.CategoryModelClass;
import com.sallu.newsex.ModelClass.CategorywiseNewsModelClass;
import com.sallu.newsex.ModelClass.DateModelClass;
import com.sallu.newsex.ModelClass.SendDaterequest;
import com.sallu.newsex.ModelClass.TrendingModelClass;
import com.sallu.newsex.ModelClass.VideosModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCall {
    @GET("api/categories.php")
    Call<CategoryModelClass> getCategory();

    @GET("api/readDate.php")
    Call<DateModelClass> getDates();

    @POST("api/trendingNews.php")
    Call<TrendingModelClass> getTrendingNews(@Body  SendDaterequest dateid);

    @POST("api/breakingNews.php")
    Call<BreakingnewsModelClass> getBreakingNews(@Body SendDaterequest dateid);

    @POST("api/categorywiseNews.php")
    Call<CategorywiseNewsModelClass> getCategorywiseNews(@Body SendDaterequest dateid);

    @POST("api/videos.php")
    Call<VideosModelClass> getVideoData(@Body SendDaterequest dateid);









}
