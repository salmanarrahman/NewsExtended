package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DateDao {

    @Insert
    void addDate(Dates date);

    @Query("select * from date")
    List<Dates> getDates();

    @Query("delete from date")
    void deleteAllFromDate();

    @Query("select * from date where date = :date")
    Dates getDateID(String date);

    @Query("select dateid from date where date = :date")
    int  getDateIDString(String date);

}
