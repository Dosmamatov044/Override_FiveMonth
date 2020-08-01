package com.example.override_fivemonthn.DataBase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.override_fivemonthn.local.BoredDao;
import com.example.override_fivemonthn.model.BoredAction;


@Database(
        entities = {BoredAction.class},
        version = BoredDatabase.VERSION,
        exportSchema = false)

public abstract class BoredDatabase extends RoomDatabase {
    public  final static int VERSION = 4;
    public abstract BoredDao boredDao();


}
