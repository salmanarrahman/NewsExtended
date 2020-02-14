package com.sallu.newsex.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VideoDao {

    @Insert
    void addVideoAddress(Video video);

    @Query("select * from video")
    List<Video> getVideo();

    @Query("delete from video")
    void deleteAllFromVideo();
}
