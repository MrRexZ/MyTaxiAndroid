package com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.response

import com.squareup.moshi.Json

data class DriverResp(@field:Json(name = "id") val id: String, @field:Json(name ="coordinate") val coordinate: DriverCoordinateResp,
                      @field:Json(name = "fleetType") val fleetType : String, @field:Json(name="heading") val heading : Double) {

}