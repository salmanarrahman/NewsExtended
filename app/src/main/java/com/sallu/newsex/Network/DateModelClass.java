package com.sallu.newsex.Network;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DateModelClass implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    private final static long serialVersionUID = -4431987180861145661L;

    /**
     * No args constructor for use in serialization
     *
     */
    public DateModelClass() {
    }

    /**
     *
     * @param data
     */
    public DateModelClass(List<Datum> data) {
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

    @SerializedName("dateID")
    @Expose
    private String dateID;
    @SerializedName("date_")
    @Expose
    private String date;
    private final static long serialVersionUID = 2027313884223148247L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param dateID
     * @param date
     */
    public Datum(String dateID, String date) {
        super();
        this.dateID = dateID;
        this.date = date;
    }

    public String getDateID() {
        return dateID;
    }

    public void setDateID(String dateID) {
        this.dateID = dateID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}}