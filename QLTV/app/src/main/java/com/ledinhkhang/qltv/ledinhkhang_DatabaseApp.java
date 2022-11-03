package com.ledinhkhang.qltv;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ledinhkhang_Sach.class}, version = 1)
public abstract class ledinhkhang_DatabaseApp extends RoomDatabase {
    public abstract ledinhkhang_ISachDao getSachDao();
    private static  ledinhkhang_DatabaseApp instance;
    public static synchronized ledinhkhang_DatabaseApp getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ledinhkhang_DatabaseApp.class,"quanlithuvien")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public static void destroyInstance() {
        instance = null;
    }
}
