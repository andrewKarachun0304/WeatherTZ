package com.example.weathertz.network

import com.example.weathertz.Constants.API_KEY
import com.example.weathertz.dto.DailyForecastsWeather
import com.example.weathertz.dto.GeopositionSearch
import com.google.android.gms.common.api.internal.ApiKey
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {
    @GET("locations/v1/cities/geoposition/search")
    fun getCityKeyAsync(
        @Query("apikey") apiKey: String,
        @Query("q") q: String,
        @Query("language") language: String
    ): Deferred<Response<GeopositionSearch>>

    @GET("forecasts/v1/daily/5day/{locationKey}")
    fun getForecastAsync(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey: String = API_KEY,
        @Query("language") language: String = "ru-ru",
        @Query("details") details: Boolean = true
    ): Deferred<Response<DailyForecastsWeather>>
}