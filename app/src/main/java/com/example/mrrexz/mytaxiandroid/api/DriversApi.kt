package com.example.mrrexz.mytaxiandroid.api

import retrofit2.http.GET
import retrofit2.http.Query

interface DriversApi {

    @GET("")
    fun getDrivers(@Query("p1Lat") p1Lat : String, @Query("p1Long") p1Long : String, @Query("p2Lat") p2Lat : String, @Query("p2Long") p2Long : String);
}