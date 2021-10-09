package com.example.weatherapp.Network

import com.example.weatherapp.Model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WeatherApi {

    //link: https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon=
    // {lon}&exclude={part}&appid={API key

    @GET("onecall?")
    fun getCurrentWeatherData(
        @Query("lat") lat: Double, @Query("lon") lon: Double,
        @Query("appId") appId: String
    ): Call<WeatherResponse>
}