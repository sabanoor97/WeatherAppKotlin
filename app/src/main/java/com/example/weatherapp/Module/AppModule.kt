package com.example.weatherapp.Module

import android.app.Application
import com.example.weatherapp.Network.WeatherApi
import com.example.weatherapp.Network.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var mApplication: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }
    @Provides
    @Singleton
    fun providesWeatherRepository(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepository(weatherApi)
    }




}