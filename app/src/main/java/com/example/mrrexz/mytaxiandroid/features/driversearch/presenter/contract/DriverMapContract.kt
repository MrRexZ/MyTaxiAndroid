package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract

import com.example.mrrexz.mytaxiandroid.base.view.BaseView

interface DriverMapContract {
    interface DriverMapView : BaseView {
        fun loadDriverDataOnMap()
        fun loadDriverDataFailed()
        fun showLoading()
        fun hideLoading()
    }
    
    interface DriverMapPresenter {
        fun displayDriverDataOnMap()
    }
}