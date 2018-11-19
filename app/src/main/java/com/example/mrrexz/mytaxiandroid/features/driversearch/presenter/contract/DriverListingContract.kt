package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract

import com.example.mrrexz.mytaxiandroid.base.view.BaseView
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb

interface DriverListingContract {
    interface DriverListingView : BaseView {
        fun showLoading()
        fun hideLoading()
        fun onDriverDataAvailable(driverDbList: List<DriverDb>)
        fun onDriverDataFetchFailed(error: String)
        fun observeDriverData()
        fun navigateToMapPage(driverId: String, coor1Bound: Coordinate, coor2Bound: Coordinate)
    }

    interface DriverListingPresenter {
        fun observeDriverData(coor1: Coordinate, coor2: Coordinate)
    }

    interface DriverListClickListener {
        fun onDriverListClick(driverId: String)
    }
}