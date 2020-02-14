package com.sallu.newsex.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categorywisenews")
public class CategorywiseNews {

    @PrimaryKey(autoGenerate = true)
    public  int id;

    @ColumnInfo(name = "newsid")
    public int newsid;

    @ColumnInfo(name = "dateid")
    public int dateid;

    @ColumnInfo(name = "categoryid")
    public int categoryid;



    @ColumnInfo(name = "headline")
    public  String headline;

    @ColumnInfo(name = "news")
    public  String news;

    @ColumnInfo(name = "reporter")
    public  String reporter;

    @ColumnInfo(name = "thumbnail")
    public  String thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public int getDateid() {
        return dateid;
    }

    public void setDateid(int dateid) {
        this.dateid = dateid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
