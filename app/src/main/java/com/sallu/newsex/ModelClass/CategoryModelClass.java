package com.sallu.newsex.ModelClass;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryModelClass implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    private final static long serialVersionUID = -2203784794394980953L;

    /**
     * No args constructor for use in serialization
     *
     */
    public CategoryModelClass() {
    }

    /**
     *
     * @param data
     */
    public CategoryModelClass(List<Datum> data) {
        super();
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }


public class Datum implements Serializable
{

    @SerializedName("categoryid")
    @Expose
    private int categoryid;
    @SerializedName("category")
    @Expose
    private String category;
    private final static long serialVersionUID = -5437075161479804888L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param category
     * @param categoryid
     */
    public Datum(int categoryid, String category) {
        super();
        this.categoryid = categoryid;
        this.category = category;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}}
