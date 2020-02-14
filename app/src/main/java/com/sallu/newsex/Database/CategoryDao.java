package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void addUser(Categories categories);

    @Query("select * from categories")
    List<Categories> getCategory();

    @Query("select count(*) from categories")
    int getUsersCount();

    @Query("delete from categories")
    void deleteAll();

}
