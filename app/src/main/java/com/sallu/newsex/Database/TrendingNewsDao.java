package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TrendingNewsDao {

    @Insert
    void addTrendingNews(TrendingNews trendingNews);

    @Query("select * from trendingnews")
    List<TrendingNews> getTrendingNews();

    @Query("delete from trendingnews")
    void deleteAllFromTrendingNews();

}
