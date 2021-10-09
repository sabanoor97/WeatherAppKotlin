package com.example.weatherapp.UI

import android.app.Application
import com.example.weatherapp.Module.AppComponent
import com.example.weatherapp.Module.AppModule
import com.example.weatherapp.Module.DaggerAppComponent
import com.example.weatherapp.Module.NetworkModule

class BaseClass : Application() {
    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}