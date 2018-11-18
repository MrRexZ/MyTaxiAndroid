package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import  com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverOverviewContract
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import dagger.Binds
import dagger.Module

@Module
abstract class DriverOverviewActivityViewModule {

    @Binds
    abstract fun bindsDriverOverviewActivity(driverOverviewActivity: DriverOverviewActivity): DriverOverviewContract.DriverOverviewView
}