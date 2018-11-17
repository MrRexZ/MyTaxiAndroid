package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view

import com.example.mrrexz.mytaxiandroid.base.view.BaseActivityView
import com.example.mrrexz.mytaxiandroid.base.view.BaseView

interface DriverOverviewView {

    fun onDriverDataFetchSuccess()
    fun onDriverDataFetchFailed()
    fun showLoading()
    fun hideLoading()
}