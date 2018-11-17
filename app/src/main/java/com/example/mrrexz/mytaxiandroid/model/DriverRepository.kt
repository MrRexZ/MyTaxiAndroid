package com.example.mrrexz.mytaxiandroid.model

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.response.DriverResp
import io.reactivex.Observable
import javax.inject.Inject

class DriverRepository {
    @Inject
    internal lateinit var driversApi: DriversApi

    fun getDrivers(driverReq : DriversReq) : Observable<List<DriverResp>> {
        return driversApi.getDrivers(driverReq.p1Lat, driverReq.p1Lon, driverReq.p2Lat, driverReq.p2Long)
    }

}