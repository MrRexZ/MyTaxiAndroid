package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment

import com.example.mrrexz.mytaxiandroid.base.view.BaseFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverListPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverListingView
import javax.inject.Inject

class DriverListingFragment : BaseFragment(), DriverListingView {

    @Inject
    lateinit var driverListPresenter : DriverListPresenter


}