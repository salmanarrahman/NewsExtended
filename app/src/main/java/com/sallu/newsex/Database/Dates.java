package com.sallu.newsex.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "date")
public class Dates {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "dateid")
    public int dateid;

    @ColumnInfo(name = "date_")
    public String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}