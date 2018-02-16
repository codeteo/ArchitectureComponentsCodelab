package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Our database for the app.
 */

@Database(entities = WeatherEntry.class, version = 1)
public abstract class SunshineDatabase extends RoomDatabase {

    public abstract WeatherDao weatherDao();

}
