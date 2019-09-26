package com.sallu.newsex.ModelClass;

public class CategorywiseNewsModelClass {

    int bgImage;
    String headline;
    String reporter;

    public CategorywiseNewsModelClass(int bgImage, String headline, String reporter) {
        this.bgImage = bgImage;
        this.headline = headline;
        this.reporter = reporter;
    }

    public int getBgImage() {
        return bgImage;
    }

    public void setBgImage(int bgImage) {
        this.bgImage = bgImage;
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
