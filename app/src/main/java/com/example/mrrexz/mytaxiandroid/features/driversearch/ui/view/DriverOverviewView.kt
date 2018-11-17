package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view

import android.support.design.widget.CoordinatorLayout
import com.example.mrrexz.mytaxiandroid.base.view.BaseView
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.response.DriverResp

interface DriverOverviewView : BaseView {

    fun onDriverDataFetchSuccess(driverDataResp : List<DriverResp>)
    fun onDriverDataFetchFailed(error : String)
    fun showLoading()
    fun hideLoading()
}