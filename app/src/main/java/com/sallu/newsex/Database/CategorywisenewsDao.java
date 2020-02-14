package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategorywisenewsDao {

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



}
