package com.example.weatherapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.weatherapp.Model.WeatherResponse
import com.example.weatherapp.Network.WeatherViewModel
import com.example.weatherapp.R
import javax.inject.Inject

class WeatherDetailFragment : Fragment() {

    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var weatherResponse: WeatherResponse
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var temperature = view.findViewById<TextView>(R.id.temperature)
        var lat = view.findViewById<TextView>(R.id.location)

        (activity?.application as BaseClass).appComponent?.inject(this)

        weatherViewModel=  ViewModelProviders.of(this, viewModelFactory)[WeatherViewModel::class.java]


        weatherViewModel.getLiveForecast().observe(viewLifecycleOwner) {
            lat.text = it.lat.toString()
        }
    }
}

