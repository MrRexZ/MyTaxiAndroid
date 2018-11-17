package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverListingFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverMapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DriverOverviewFragmentModule {



    @ContributesAndroidInjector(modules = [DriverListingViewModule::class, DriverListingFragmentModule::class])
    abstract fun contributeDriverListingFragment() : DriverListingFragment

    @ContributesAndroidInjector
    abstract fun contributeDriverMapFragment() : DriverMapFragment

}