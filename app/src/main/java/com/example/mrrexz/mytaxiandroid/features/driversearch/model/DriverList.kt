package com.example.mrrexz.mytaxiandroid.features.driversearch.model

import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.response.DriverResp
import com.squareup.moshi.Json

data class DriverList(@field:Json(name="poiList") val drivers : List<DriverResp>) {
}