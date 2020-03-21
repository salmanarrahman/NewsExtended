package com.sallu.newsex.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sallu.newsex.Utils.Config;

@Database(entities = {Dates.class,Categories.class, TrendingNews.class,BreakingNews.class,CategorywiseNews.class,Video.class},version = 1, exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {

    private static MyAppDatabase INSTANCE;

    public abstract MyDao dao();


    public static MyAppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, MyAppDatabase.class, Config.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
