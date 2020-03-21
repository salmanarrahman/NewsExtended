package com.sallu.newsex.Database;

import java.util.List;

public class DatabaseCall {

    public static BreakingNews addBreakingNews(MyAppDatabase db,BreakingNews breakingNews){

        db.dao().addBreakingNews(breakingNews);
        return breakingNews;

    }

    public static List<BreakingNews> getBreakingNews(MyAppDatabase db){
        return db.dao().getBreakingNews();
    }

    public static  Categories addCategory(MyAppDatabase db, Categories categories){
        db.dao().addUser(categories);
        return categories;
    }
    public static List<Categories> getCategoryList(MyAppDatabase db){
        return  db.dao().getCategory();

    }

    public static Dates getDateID(MyAppDatabase db,String date){
        return db.dao().getDateID(date);
    }

    public static int getDateIDstring(MyAppDatabase db,String date){
        return db.dao().getDateIDString(date);
    }

    public static Dates addDate(MyAppDatabase db, Dates date){
        db.dao().addDate(date);
        return date;
    }
    public static List<Dates> getDates(MyAppDatabase db){
        return  db.dao().getDates();
    }

    public static CategorywiseNews addCategorywiseNews(MyAppDatabase db,CategorywiseNews categorywiseNews){
        db.dao().addCategorywiseNews(categorywiseNews);
        return  categorywiseNews;
    }
    public static List<CategorywiseNews> getCategorywiseNews(MyAppDatabase db){
        return  db.dao().getCategorywiseNews();
    }

    public static List<CategorywiseNews> getCategorywiseNewsByCategory(MyAppDatabase db,String  CategoryID){
        return  db.dao().getNewsByID(CategoryID);
    }

    public static Video addVideos(MyAppDatabase db,Video video){
        db.dao().addVideoAddress(video);
        return video;
    }
    public static List<Video> getVideos(MyAppDatabase db){
        return  db.dao().getVideo();
    }

    public  static TrendingNews addTrendingNews(MyAppDatabase db,TrendingNews trendingNews){
        db.dao().addTrendingNews(trendingNews);
        return trendingNews;
    }
    public static  List<TrendingNews> getTrendingNews(MyAppDatabase db){
        return  db.dao().getTrendingNews();
    }

    public  static  int getCategorySetNumber(MyAppDatabase db){
        return  db.dao().getUsersCount();
    }

    public static void deleteData(MyAppDatabase db){
        db.dao().deleteAll();
    }
    public static void deleteFromBreakingNews(MyAppDatabase db){
        db.dao().deleteAllFromBreakingNews();
    }
    public static void deleteFromTrendingnNews(MyAppDatabase db){
        db.dao().deleteAllFromTrendingNews();
    }
    public  static  void deleteVideos(MyAppDatabase db){
        db.dao().deleteAllFromVideo();
    }
    public static void deleteFromDates(MyAppDatabase db){
        db.dao().deleteAllFromDate();
    }
    public static void deleteFromCAtegorywiseNews(MyAppDatabase db){
        db.dao().deleteAllFromCategorywisenews();
    }



}
