package com.example.mrrexz.mytaxiandroid.util

fun isValidLatLng(lat: Double?, lng: Double?): Boolean {
    if (lat == null || lng == null) return false
    if (lat < -90 || lat > 90) {
        return false
    } else if (lng < -180 || lng > 180) {
        return false
    }
    return true
}