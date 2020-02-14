package com.sallu.newsex.ModelClass;
import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VideosModelClass implements Serializable {

    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;

    /**
     * No args constructor for use in serialization
     */
    public VideosModelClass() {
    }

    /**
     * @param videos
     */
    public VideosModelClass(List<Video> videos) {
        super();
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }


public class Video implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("videoaddress")
    @Expose
    private String videoaddress;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("cameraman")
    @Expose
    private String cameraman;
    @SerializedName("news")
    @Expose
    private String news;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("dateid")
    @Expose
    private int dateid;
    private final static long serialVersionUID = -1538216134963229270L;

    /**
     * No args constructor for use in serialization
     */
    public Video() {
    }

    /**
     * @param videoaddress
     * @param news
     * @param thumbnail
     * @param cameraman
     * @param dateid
     * @param id
     * @param title
     */
    public Video(int id, String videoaddress, String title, String cameraman, String news, String thumbnail, int dateid) {
        super();
        this.id = id;
        this.videoaddress = videoaddress;
        this.title = title;
        this.cameraman = cameraman;
        this.news = news;
        this.thumbnail = thumbnail;
        this.dateid = dateid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoaddress() {
        return videoaddress;
    }

    public void setVideoaddress(String videoaddress) {
        this.videoaddress = videoaddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCameraman() {
        return cameraman;
    }

    public void setCameraman(String cameraman) {
        this.cameraman = cameraman;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getDateid() {
        return dateid;
    }

    public void setDateid(int dateid) {
        this.dateid = dateid;
    }

}

    }
