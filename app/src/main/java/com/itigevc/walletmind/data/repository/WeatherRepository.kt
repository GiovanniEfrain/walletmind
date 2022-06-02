package com.itigevc.walletmind.data.repository

import com.itigevc.walletmind.data.locale.dao.WeatherDao
import com.itigevc.walletmind.data.locale.model.WeatherCharacteristics
import com.itigevc.walletmind.data.remote.WeatherInterface
import com.itigevc.walletmind.data.remote.model.CurrentWeatherResponse
import com.itigevc.walletmind.utils.Constants
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepository  @Inject constructor(
    private val api: WeatherInterface,
    private val locale: WeatherDao
){

    fun getWeatherBroadcast(
        lat: Double,
        lon: Double
    ): Observable<CurrentWeatherResponse> {
        return api.getCurrentWeather(lat, lon, Constants.appIdKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun addWeatherRecordNewRecord(weatherCharacteristics: WeatherCharacteristics): Completable {
        return Completable.fromAction {
            locale.insert(weatherCharacteristics)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun fetchWeatherRecords(): Observable<List<WeatherCharacteristics>> =
        locale.getWeatherHistory().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}