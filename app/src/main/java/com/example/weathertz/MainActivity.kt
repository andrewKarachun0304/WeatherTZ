package com.example.weathertz

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 101
private const val PERMISSION_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION

class MainActivity : AppCompatActivity() {
    private val listener by lazy {
        LocationListener { location ->
            lat = location.latitude
            lon = location.longitude

//            Log.d("TAG",  "$lat $lon" )
//
//            text_view.text = "$lat $lon"
        }
    }
    private val manager by lazy {
        getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }
    private val criteria by lazy { manager.getBestProvider(Criteria(), true) ?: "" }
    private var mLocationPermissionGranted = false
    private var lat: Double? = null
    private var lon: Double? = null

    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getLocationPermission()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                text_view.text = "${location?.latitude} ${location?.longitude}"
            }
    }

    private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, PERMISSION_LOCATION) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            mLocationPermissionGranted = true
            manager.requestLocationUpdates(criteria, 1000, 1f, listener)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(PERMISSION_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        mLocationPermissionGranted = false
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true
                }
            }
        }
    }
}