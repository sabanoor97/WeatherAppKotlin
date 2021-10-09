package com.example.weatherapp.Network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.Model.WeatherResponse
import javax.inject.Inject

class WeatherViewModel @Inject constructor(var weatherRepository: WeatherRepository) : ViewModel() {


    fun getLiveForecast(): MutableLiveData<WeatherResponse> {
        return weatherRepository.getWeatherDetails()
    }

}