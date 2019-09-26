package com.sallu.newsex.Database;

import java.util.List;

public class DatabaseCall {

    public static  Categories addData(MyAppDatabase db,Categories categories){
        db.myDao().addUser(categories);
        return categories;
    }
    public static List<Categories> getAllData(MyAppDatabase db){
        return  db.myDao().getCategory();

    }
    public  static  int getDataSetNumber(MyAppDatabase db){
        return  db.myDao().getUsersCount();
    }

    public static void deleteData(MyAppDatabase db){
        db.myDao().deleteAll();
    }

}
