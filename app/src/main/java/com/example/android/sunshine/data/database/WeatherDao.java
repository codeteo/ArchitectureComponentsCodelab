package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.sql.Date;

/**
 * Dao to access weather table .
 */

@Dao
public interface WeatherDao {

    /**
     * Inserts any number of weather entries in database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... entries);

    /**
     * Returns a weather entry searching in weather table by date.
     */
    @Query("SELECT * FROM weather WHERE date = :date")
    WeatherEntry getWeatherByDate(Date date);

}
