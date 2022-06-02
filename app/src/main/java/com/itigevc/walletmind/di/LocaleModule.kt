package com.itigevc.walletmind.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocaleModule {

    @Provides
    @Singleton
    fun provideAppDB(@ApplicationContext appContext: Context) : WalletMindDataBase {
        return Room.databaseBuilder(
            appContext,
            WalletMindDataBase::class.java,
            "wallet_mind_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelWeatherDao(weatherDataBase: WalletMindDataBase): WeatherDao {
        return weatherDataBase.channelDao()
    }

}