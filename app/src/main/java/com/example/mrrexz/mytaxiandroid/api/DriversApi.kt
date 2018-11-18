package com.example.mrrexz.mytaxiandroid.api

import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.DriverList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DriversApi {

    @GET(".")
    fun getDrivers(@Query("p1Lat") p1Lat : Double?, @Query("p1Lon") p1Long : Double?,
                   @Query("p2Lat") p2Lat : Double?, @Query("p2Lon") p2Long : Double?) : Observable<DriverList>
}