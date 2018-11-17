package com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.response

import com.squareup.moshi.Json

data class DriverCoordinateResp(@field:Json(name = "latitude") val latitude : Double, @field:Json(name ="longitude") val longitude : Double) {
}