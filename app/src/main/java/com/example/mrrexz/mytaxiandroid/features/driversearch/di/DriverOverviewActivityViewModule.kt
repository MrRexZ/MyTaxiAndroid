package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverListingFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverListingView
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverOverviewView
import dagger.Binds
import dagger.Module

@Module
abstract class DriverOverviewActivityViewModule {

    @Binds
    abstract fun bindsDriverOverviewActivity(driverOverviewActivity: DriverOverviewActivity): DriverOverviewView
}