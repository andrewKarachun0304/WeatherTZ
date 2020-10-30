package com.example.weathertz

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.*

private const val PERMISSION_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
private const val PERMISSION_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
private const val PERMISSIONS_REQUEST_ACCESS_LOCATION = 1010

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
            localityVM.getPermission.postValue(true)
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
                    localityVM.getPermission.postValue(true)
                }
            }
        }
    }

    override fun onStartFragment() {
        checkPermission()
    }
}