package com.example.weathertz

import android.annotation.SuppressLint
import android.content.Context

import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_weather_list.*

class WeatherListFragment : Fragment() {
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

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        val listener = context as Listener
        listener.onStartFragment()
        localityVM.getPermission.observe(requireActivity(), {
            getLastLocation()
        })

    }
    private fun isLocationEnabled(): Boolean {
        val locationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    @SuppressLint("MissingPermission")
    fun getLastLocation() {
        if (isLocationEnabled()) {
            fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
                val location: Location? = task.result
                if (location == null) {
                    newLocationData()
                } else {
                    location_tv.text =
                        "You Current Location is : Long: " + location.longitude + " , Lat: " + location.latitude
                }
            }
        } else {
//            Toast.makeText(this, "Please Turn on Your device Location", Toast.LENGTH_SHORT)
//                .show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun newLocationData() {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 1
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest, locationCallback, Looper.myLooper()
        )
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val lastLocation: Location = locationResult.lastLocation
            location_tv.text =
                "You Last Location is : Long: " + lastLocation.longitude + " , Lat: " + lastLocation.latitude
        }
    }

    interface Listener{
        fun onStartFragment()
    }
}