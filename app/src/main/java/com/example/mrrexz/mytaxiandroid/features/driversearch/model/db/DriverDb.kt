package com.example.mrrexz.mytaxiandroid.features.driversearch.model.db

import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class DriverDb(
    @PrimaryKey var id: String = "",
    var searchCoor1Lat: Double? = null,
    var searchCoor1Lon: Double? = null,
    var searchCoor2Lat: Double? = null,
    var searchCoor2Lon: Double? = null,
    var driverCoordLat: Double? = null,
    var driverCoordLon: Double? = null,
    var fleetType: String = "",
    var heading: Double? = null
) : RealmObject()