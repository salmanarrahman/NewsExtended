package com.sallu.newsex.ModelClass;

import android.graphics.drawable.Drawable;

public class BreakingnewsModelClass {

    int bgImage;
    String breakingNews,breakingNewsReporter;

    public BreakingnewsModelClass(int backgroundImage, String breakingNews, String breakingNewsReporter) {
        this.bgImage = backgroundImage;
        this.breakingNews = breakingNews;
        this.breakingNewsReporter = breakingNewsReporter;
    }


    public int getBgImage() {
        return bgImage;
    }

    public void setBgImage(int bgImage) {
        this.bgImage = bgImage;
    }

    public String getBreakingNews() {
        return breakingNews;
    }

    public void setBreakingNews(String breakingNews) {
        this.breakingNews = breakingNews;
    }

    public String getBreakingNewsReporter() {
        return breakingNewsReporter;
    }

    public void setBreakingNewsReporter(String breakingNewsReporter) {
        this.breakingNewsReporter = breakingNewsReporter;
    }
}
