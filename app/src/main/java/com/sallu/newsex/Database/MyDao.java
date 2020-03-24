package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MyDao {
    @Insert
    void addBreakingNews(BreakingNews breakingNews);

    @Query("select * from breakingnews")
    List<BreakingNews> getBreakingNews();

    @Query("delete from breakingnews")
    void deleteAllFromBreakingNews();
    @Insert
    void addUser(Categories categories);

    @Query("select * from categories")
    List<Categories> getCategory();

    @Query("select count(*) from categories")
    int getUsersCount();

    @Query("delete from categories")
    void deleteAll();
    @Insert
    void addCategorywiseNews(CategorywiseNews categorywiseNews);

    @Query("select * from categorywisenews")
    List<CategorywiseNews> getCategorywiseNews();

    @Query("select * from categorywisenews where categoryid = :id")
    List<CategorywiseNews> getNewsByID(String id);

    @Query("delete from categorywisenews")
    void deleteAllFromCategorywisenews();

    @Query("select * from categorywisenews where id = :id")
    CategorywiseNews getNewsById(String id);

    @Insert
    void addDate(Dates date);

    @Query("select * from date")
    List<Dates> getDates();

    @Query("delete from date")
    void deleteAllFromDate();

    @Query("select * from date where date_ = :date")
    Dates getDateID(String date);

    @Query("select dateid from date where date_ = :date")
    int  getDateIDString(String date);

    @Insert
    void addTrendingNews(TrendingNews trendingNews);

    @Query("select * from trendingnews")
    List<TrendingNews> getTrendingNews();

    @Query("delete from trendingnews")
    void deleteAllFromTrendingNews();

    @Insert
    void addVideoAddress(Video video);

    @Query("select * from video")
    List<Video> getVideo();

    @Query("delete from video")
    void deleteAllFromVideo();
}
