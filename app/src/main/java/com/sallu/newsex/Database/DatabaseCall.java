package com.sallu.newsex.Database;

import java.util.List;

public class DatabaseCall {

    public static BreakingNews addBreakingNews(MyAppDatabase db,BreakingNews breakingNews){

        db.breakingNewsDao().addBreakingNews(breakingNews);
        return breakingNews;

    }

    public static List<BreakingNews> getBreakingNews(MyAppDatabase db){
        return db.breakingNewsDao().getBreakingNews();
    }

    public static  Categories addCategory(MyAppDatabase db, Categories categories){
        db.categoryDao().addUser(categories);
        return categories;
    }
    public static List<Categories> getCategoryList(MyAppDatabase db){
        return  db.categoryDao().getCategory();

    }

    public static Dates getDateID(MyAppDatabase db,String date){
        return db.dateDao().getDateID(date);
    }

    public static int getDateIDstring(MyAppDatabase db,String date){
        return db.dateDao().getDateIDString(date);
    }

    public static Dates addDate(MyAppDatabase db, Dates date){
        db.dateDao().addDate(date);
        return date;
    }
    public static List<Dates> getDates(MyAppDatabase db){
        return  db.dateDao().getDates();
    }

    public static CategorywiseNews addCategorywiseNews(MyAppDatabase db,CategorywiseNews categorywiseNews){
        db.categorywisenewsDao().addCategorywiseNews(categorywiseNews);
        return  categorywiseNews;
    }
    public static List<CategorywiseNews> getCategorywiseNews(MyAppDatabase db){
        return  db.categorywisenewsDao().getCategorywiseNews();
    }

    public static List<CategorywiseNews> getCategorywiseNewsByCategory(MyAppDatabase db,String  CategoryID){
        return  db.categorywisenewsDao().getNewsByID(CategoryID);
    }

    public static Video addVideos(MyAppDatabase db,Video video){
        db.videoDao().addVideoAddress(video);
        return video;
    }
    public static List<Video> getVideos(MyAppDatabase db){
        return  db.videoDao().getVideo();
    }

    public  static TrendingNews addTrendingNews(MyAppDatabase db,TrendingNews trendingNews){
        db.trendingNewsDao().addTrendingNews(trendingNews);
        return trendingNews;
    }
    public static  List<TrendingNews> getTrendingNews(MyAppDatabase db){
        return  db.trendingNewsDao().getTrendingNews();
    }

    public  static  int getCategorySetNumber(MyAppDatabase db){
        return  db.categoryDao().getUsersCount();
    }

    public static void deleteData(MyAppDatabase db){
        db.categoryDao().deleteAll();
    }
    public static void deleteFromBreakingNews(MyAppDatabase db){
        db.breakingNewsDao().deleteAllFromBreakingNews();
    }
    public static void deleteFromTrendingnNews(MyAppDatabase db){
        db.trendingNewsDao().deleteAllFromTrendingNews();
    }
    public  static  void deleteVideos(MyAppDatabase db){
        db.videoDao().deleteAllFromVideo();
    }
    public static void deleteFromDates(MyAppDatabase db){
        db.dateDao().deleteAllFromDate();
    }
    public static void deleteFromCAtegorywiseNews(MyAppDatabase db){
        db.categorywisenewsDao().deleteAllFromCategorywisenews();
    }



}
