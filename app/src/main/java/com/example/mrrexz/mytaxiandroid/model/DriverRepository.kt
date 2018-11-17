package com.example.mrrexz.mytaxiandroid.model

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import javax.inject.Inject

class DriverRepository {
    @Inject
    lateinit var driversApi: DriversApi

    fun getDrivers(p1Lat : String, p1Long : String, p2Lat : String, p2Long : String) {
        return driversApi.getDrivers(p1Lat, p1Long, p2Lat, p2Long)
    }

}