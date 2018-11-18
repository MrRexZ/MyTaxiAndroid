package com.example.mrrexz.mytaxiandroid.model

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.DriverList
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import io.reactivex.Flowable
import io.reactivex.Observable
import java.sql.Driver

interface DriverRepository {

    fun getDriversFromNetwork(driverReq: DriversReq): Observable<DriverList>
    fun getDrivers(driverReq: DriversReq): Flowable<List<DriverDb>>
    fun insertDrivers(driverReq : DriversReq, driverList: DriverList)
    fun deleteAllDrivers(driverReq : DriversReq)
}