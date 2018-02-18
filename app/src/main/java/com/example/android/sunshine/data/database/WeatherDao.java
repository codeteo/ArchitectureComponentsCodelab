package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;

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
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    /**
     * Counts the number of future dates stored in the table.
     *
     * @return num of future dates.
     */
    @Query("SELECT COUNT(id) FROM weather WHERE date >= :date")
    int countAllFutureWeather(Date date);

}
