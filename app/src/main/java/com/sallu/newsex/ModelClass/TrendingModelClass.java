package com.sallu.newsex.ModelClass;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class TrendingModelClass implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    private final static long serialVersionUID = -2431403417924483726L;

    /**
     * No args constructor for use in serialization
     *
     */
    public TrendingModelClass() {
    }

    /**
     *
     * @param data
     */
    public TrendingModelClass(List<Datum> data) {
        super();
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public static class Datum implements Serializable
    {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("dateid")
        @Expose
        private String dateid;
        @SerializedName("headline")
        @Expose
        private String headline;
        @SerializedName("reporter")
        @Expose
        private String reporter;
        @SerializedName("news")
        @Expose
        private String news;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        private final static long serialVersionUID = -8962040939422538975L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Datum() {
        }

        /**
         *
         * @param news
         * @param thumbnail
         * @param dateid
         * @param reporter
         * @param id
         * @param headline
         */
        public Datum(int id, String dateid, String headline, String reporter, String news, String thumbnail) {
            super();
            this.id = id;
            this.dateid = dateid;
            this.headline = headline;
            this.reporter = reporter;
            this.news = news;
            this.thumbnail = thumbnail;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDateid() {
            return dateid;
        }

        public void setDateid(String dateid) {
            this.dateid = dateid;
        }

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }

        public String getReporter() {
            return reporter;
        }

        public void setReporter(String reporter) {
            this.reporter = reporter;
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

    }

}