package com.sallu.newsex.ModelClass;

public class VideosModelClass {

    int thumbnail;
    String  duration;
    String news,reporter;

    public VideosModelClass(int thumbnail, String  duration, String news, String reporter) {
        this.thumbnail = thumbnail;
        this.duration = duration;
        this.news = news;
        this.reporter = reporter;
    }

    public VideosModelClass(String  duration, String news, String reporter) {
        this.duration = duration;
        this.news = news;
        this.reporter = reporter;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String  getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
}
