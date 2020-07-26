package com.example.override_fivemonthn;

import android.app.Application;


import androidx.room.Room;

import com.example.override_fivemonthn.DataBase.BoredDatabase;

import com.example.override_fivemonthn.local.BoredStorage;
public class App extends Application {

    public static BoredApiClient boredApiClient;
    private static BoredDatabase boredDatabase;
    public static BoredStorage boredStorage;
    public static App instance;


    @Override
    public void onCreate() {
        super.onCreate();

        boredApiClient = new BoredApiClient();
        instance = this;
        boredDatabase = Room.databaseBuilder(
                this,
                BoredDatabase.class,
                "bored.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        boredStorage = new BoredStorage(boredDatabase.boredDao());
    }

    public static App getInstance() {
        return instance;
    }

    public static BoredDatabase getDatabase() {
        return boredDatabase;
    }


}
