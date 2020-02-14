package com.sallu.newsex.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "video")
public class Video {

    @PrimaryKey(autoGenerate = true)
    public  int id;

    @ColumnInfo(name = "videoid")
    public int videoid;

    @ColumnInfo(name = "dateid")
    public  int dateid;

    @ColumnInfo(name = "title")
    public  String title;

    @ColumnInfo(name = "videoaddress")
    public  String videoaddress;

    @ColumnInfo(name = "cameraman")
    public  String cameraman;

    @ColumnInfo(name = "thumbnail")
    public  String thumbnail;

    @ColumnInfo(name = "news")
    public String news;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public int getDateid() {
        return dateid;
    }

    public void setDateid(int dateid) {
        this.dateid = dateid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoaddress() {
        return videoaddress;
    }

    public void setVideoaddress(String videoaddress) {
        this.videoaddress = videoaddress;
    }

    public String getCameraman() {
        return cameraman;
    }

    public void setCameraman(String cameraman) {
        this.cameraman = cameraman;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
