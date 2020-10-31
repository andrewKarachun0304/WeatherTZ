package com.example.weathertz.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.weathertz.Constants.PERMISSIONS_REQUEST_ACCESS_LOCATION
import com.example.weathertz.Constants.PERMISSION_COARSE_LOCATION
import com.example.weathertz.Constants.PERMISSION_FINE_LOCATION
import com.example.weathertz.R
import com.example.weathertz.ui.fragments.WeatherListFragment
import com.example.weathertz.viewmodel.ViewModelLocality

class MainActivity : AppCompatActivity(), WeatherListFragment.Listener {

    private val localityVM by lazy {
        ViewModelProvider(this).get(ViewModelLocality::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this, PERMISSION_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, PERMISSION_COARSE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            isLocationEnabled()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                PERMISSIONS_REQUEST_ACCESS_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isLocationEnabled()
                }
            }
        }
    }

    private fun isLocationEnabled() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            localityVM.getPermission.postValue(true)
        } else {
            Toast.makeText(this, "Please turn on GPS", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStartFragment() {
        checkPermission()
    }
}