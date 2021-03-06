package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract

import com.example.mrrexz.mytaxiandroid.base.view.BaseView
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.vo.Driver

interface DriverMapContract {
    interface DriverMapView : BaseView {
        fun loadDriverDataOnMap(driverList: List<Driver>)
        fun loadDriverDataFailed(err: String)
        fun mapFocusOnLatLng(lat: Double, lon: Double)
        fun initMap()
        fun renderCarIconOnMap(lat: Double, lon: Double, fleetType: String)
        fun requestDisplayData(boundsCoor1: Coordinate, boundsCoor2: Coordinate)
        fun notifyDriverNotFound()
        fun showLoading()
        fun hideLoading()
    }

    interface DriverMapPresenter {
        fun displayDriverDataOnMap(coor1: Coordinate, coor2: Coordinate)
    }
}