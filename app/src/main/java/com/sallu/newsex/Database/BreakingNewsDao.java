package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface BreakingNewsDao {

    @Insert
    void addBreakingNews(BreakingNews breakingNews);

    @Query("select * from breakingnews")
    List<BreakingNews> getBreakingNews();

    @Query("delete from breakingnews")
    void deleteAllFromBreakingNews();






}
