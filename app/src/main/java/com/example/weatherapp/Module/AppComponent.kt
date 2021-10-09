package com.example.weatherapp.Module

import com.example.weatherapp.MainActivity
import com.example.weatherapp.UI.WeatherDetailFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class,ViewModelModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(weatherDetail: WeatherDetailFragment)

}