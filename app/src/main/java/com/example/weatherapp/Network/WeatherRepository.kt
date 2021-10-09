package com.example.weatherapp.Network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.Model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(val weatherApi: WeatherApi) {


    fun getWeatherDetails(): WeatherResponse {

        val weatherData = MutableLiveData<WeatherResponse>()

        weatherApi.getCurrentWeatherData(31.4674, 74.2660, "ea59bd03027ab3b22a3cc716921d22c0")
            .enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse?>
                ) {
                    if (response.isSuccessful) {
                        weatherData.value = response.body()
                        Log.d("Retrofit", "$weatherData")
                    } else (
                            Log.d("", "Request failed"))
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable?) {
                    Log.d("Retrofit failed", "$t")
                }
            })

    }
}