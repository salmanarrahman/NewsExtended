package com.sallu.newsex.ModelClass;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DateModelClass implements Serializable {

    @SerializedName("data")
    @Expose
    private List<DateModelClass.Datum> data = null;

    public List<DateModelClass.Datum> getData() {
        return data;
    }

    public void setData(List<DateModelClass.Datum> data) {
        this.data = data;
    }


    public class Datum implements Serializable {

        @SerializedName("dateID")
        @Expose
        private int dateID;
        @SerializedName("date_")
        @Expose
        private String date;

        public int getDateID() {
            return dateID;
        }

        public void setDateID(int dateID) {
            this.dateID = dateID;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }

}