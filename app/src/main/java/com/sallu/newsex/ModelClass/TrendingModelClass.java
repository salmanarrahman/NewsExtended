package com.sallu.newsex.ModelClass;

import android.graphics.drawable.Drawable;

public class TrendingModelClass {

    int backgroundImage;
    String headline,reporter;

    public TrendingModelClass(int backgroundImage, String headline, String reporter) {
        this.backgroundImage = backgroundImage;
        this.headline = headline;
        this.reporter = reporter;
    }



    public int getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(int backgroundImage) {
        this.backgroundImage = backgroundImage;
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
}
