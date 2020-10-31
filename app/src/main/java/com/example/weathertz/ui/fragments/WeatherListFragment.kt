package com.example.weathertz.ui.fragments

import android.annotation.SuppressLint

import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.weathertz.Constants.API_KEY
import com.example.weathertz.R
import com.example.weathertz.retrofit.RetrofitFactory
import com.example.weathertz.utils.launchIO
import com.example.weathertz.utils.launchUI
import com.example.weathertz.viewmodel.ViewModelLocality
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.fragment_weather_list.*

class WeatherListFragment : Fragment() {
    private val retrofit by lazy {
        RetrofitFactory.getInstance()
    }
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest

    private val localityVM by lazy {
        ViewModelProvider(requireActivity()).get(ViewModelLocality::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())

        val listener = context as Listener
        listener.onStartFragment()
        localityVM.getPermission.observe(requireActivity(), {
            getLastLocation()
        })
    }


    @SuppressLint("MissingPermission")
    fun getLastLocation() {
        launchIO {
            fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
                val location: Location? = task.result
                if (location == null) {
                    newLocationData()
                } else {
                    launchUI {
                        startGeoResponse("${location.latitude}, ${location.longitude}")
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun newLocationData() {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 1
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest, locationCallback, Looper.myLooper()
        )
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            launchIO {
                val lastLocation: Location = locationResult.lastLocation
                launchUI {
                    startGeoResponse("${lastLocation.latitude}, ${lastLocation.longitude}")
                }
            }
        }
    }

    private fun startGeoResponse(q: String) {
        launchIO {
            val geoResponse = retrofit.getCityKeyAsync(
                apiKey = API_KEY,
                q = q,
                language = "ru-ru"
            ).await()
            val response = geoResponse.body()
            startWeatherForecast(response?.key ?: "")
        }
    }

    private suspend fun startWeatherForecast(key: String) {
        val forecastResponse = retrofit.getForecastAsync(
            locationKey = key
        ).await()
        val response = forecastResponse.body()
        launchUI {
            location_tv.text = response.toString()
        }
    }

    interface Listener {
        fun onStartFragment()
    }
}