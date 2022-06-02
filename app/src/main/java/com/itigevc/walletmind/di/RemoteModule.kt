package com.itigevc.walletmind.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun provideWeatherApi(
        @Named("retrofit") retrofit: Retrofit
    ) : WeatherInterface {
        return retrofit.create(WeatherInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(
        api: WeatherInterface, locale: WeatherDao
    ): WeatherRepository {
        return WeatherRepository(api,locale)
    }

}