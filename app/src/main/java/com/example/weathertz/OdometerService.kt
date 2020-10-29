package com.example.weathertz

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.os.Binder
import android.os.IBinder
import androidx.core.content.ContextCompat

class OdometerService : Service() {

    companion object {
        private var lat: Double = 0.toDouble()
        private var lon: Double = 0.toDouble()
    }

    private val binder = OdometerBinder()
    private var listener: LocationListener? = null
    private var manager: LocationManager? = null

    override fun onBind(intent: Intent): IBinder {
        return this.binder
    }

    inner class OdometerBinder : Binder() {
        fun giveOdometer(): OdometerService {
            return this@OdometerService
        }
    }

    override fun onCreate() {
        listener = LocationListener { location ->
            lat = location.latitude
            lon = location.longitude
        }

        manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
            manager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1f,
                listener as LocationListener
            )
    }

    override fun onDestroy() {
        if (manager != null && listener != null) {
            manager?.removeUpdates(listener!!)

            manager = null
            listener = null
        }
    }

    fun getDistance(): String {
        return "${lat + lon}"
    }
}