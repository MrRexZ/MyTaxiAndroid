package com.example.mrrexz.mytaxiandroid.features.main.view

import com.example.mrrexz.mytaxiandroid.base.view.BaseView

interface MainView : BaseView {
    fun navigateToDriverOverview(lat1 : Double?, lon1 : Double?, lat2 : Double?, lon2: Double?)
    fun onShowDriverListSelected()
}