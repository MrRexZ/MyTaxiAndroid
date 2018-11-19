package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverMapContract
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverMapFragment
import dagger.Binds
import dagger.Module

@Module
abstract class DriverMapViewModule {

    @Binds
    abstract fun bindDriverMapFragment(driverMapFragment : DriverMapFragment) : DriverMapContract.DriverMapView
}