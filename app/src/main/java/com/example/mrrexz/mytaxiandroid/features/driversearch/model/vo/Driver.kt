package com.example.mrrexz.mytaxiandroid.features.driversearch.model.vo

import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import io.realm.RealmObject

data class Driver(val id : String, val coord : Coordinate, val fleetType : String, val heading : Double)