package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view

import com.example.mrrexz.mytaxiandroid.base.view.BaseView

interface DriverOverviewView : BaseView {

    fun onDriverDataFetchSuccess()
    fun onDriverDataFetchFailed()
    fun showLoading()
    fun hideLoading()
}