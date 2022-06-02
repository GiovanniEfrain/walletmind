package com.itigevc.walletmind.data.locale.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itigevc.walletmind.data.locale.model.WeatherCharacteristics
import io.reactivex.rxjava3.core.Observable

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherCharacteristics: WeatherCharacteristics): Long

    @Query("SELECT * FROM weather_history_Characteristics")
    fun getWeatherHistory(): Observable<List<WeatherCharacteristics>>

}