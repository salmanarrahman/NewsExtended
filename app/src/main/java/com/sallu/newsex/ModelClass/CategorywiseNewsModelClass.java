package com.sallu.newsex.ModelClass;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategorywiseNewsModelClass implements Serializable {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    private final static long serialVersionUID = -3899055334131527887L;

    /**
     * No args constructor for use in serialization
     */
    public CategorywiseNewsModelClass() {
    }

    /**
     * @param data
     */
    public CategorywiseNewsModelClass(List<Datum> data) {
        super();
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


    public class Datum implements Serializable {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("dateid")
        @Expose
        private int dateid;
        @SerializedName("headline")
        @Expose
        private String headline;
        @SerializedName("reporter")
        @Expose
        private String reporter;
        @SerializedName("news")
        @Expose
        private String news;
        @SerializedName("categoryid")
        @Expose
        private int categoryid;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        private final static long serialVersionUID = -6568395580819775487L;

        /**
         * No args constructor for use in serialization
         */
        public Datum() {
        }

        /**
         * @param news
         * @param thumbnail
         * @param dateid
         * @param reporter
         * @param id
         * @param headline
         * @param categoryid
         */
        public Datum(int id, int dateid, String headline, String reporter, String news, int categoryid, String thumbnail) {
            super();
            this.id = id;
            this.dateid = dateid;
            this.headline = headline;
            this.reporter = reporter;
            this.news = news;
            this.categoryid = categoryid;
            this.thumbnail = thumbnail;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDateid() {
            return dateid;
        }

        public void setDateid(int dateid) {
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

        public int getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(int categoryid) {
            this.categoryid = categoryid;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

    }
}