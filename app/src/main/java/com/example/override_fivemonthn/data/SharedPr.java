package com.example.override_fivemonthn.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPr  {
    private SharedPreferences sharedPreferences;
    private  static volatile SharedPr place;

    public SharedPr (Context context){
        place =this;
        sharedPreferences = context.getSharedPreferences("settings",Context.MODE_PRIVATE);

    }public static SharedPr getInstance(Context context){
        if (place == null) new SharedPr(context);
        return place;

    }public boolean isShown(){
        return sharedPreferences.getBoolean("isShown",false);
    }
    public void saveShown(){
        sharedPreferences.edit().putBoolean("isShown",true).apply();
    }





}