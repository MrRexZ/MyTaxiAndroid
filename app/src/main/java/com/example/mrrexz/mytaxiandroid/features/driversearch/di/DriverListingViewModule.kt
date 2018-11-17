package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverListingFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverListingView
import dagger.Binds
import dagger.Module

@Module
abstract class DriverListingViewModule {


    @Binds
    abstract fun bindsDriverListFragment(driverListingFragment: DriverListingFragment): DriverListingView
}