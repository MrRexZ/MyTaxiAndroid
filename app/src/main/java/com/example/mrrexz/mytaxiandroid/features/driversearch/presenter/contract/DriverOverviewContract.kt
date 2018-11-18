package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract

import com.example.mrrexz.mytaxiandroid.base.view.BaseView
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.DriverList

interface DriverOverviewContract {

    interface DriverOverviewView : BaseView {
        fun onDriverDataAvailable(driverDbList: List<DriverDb>)
        fun onDriverDataFetchSuccess(driverDataResp: DriverList)
        fun onDriverDataFetchFailed(error: String)
        fun showLoading()
        fun hideLoading()
    }

    interface DriverOverviewPresenter {
        fun requestDriverData(coor1: Coordinate, coor2: Coordinate)
        fun observeDriverData(coor1: Coordinate, coor2: Coordinate)
    }
}

