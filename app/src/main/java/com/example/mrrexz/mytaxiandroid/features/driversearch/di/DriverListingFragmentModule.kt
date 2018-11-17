package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverListPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverListingView
import dagger.Module
import dagger.Provides

@Module
class DriverListingFragmentModule {

    @Provides
    fun provideDriverListPresenter(driverListingView: DriverListingView) : DriverListPresenter {
        return DriverListPresenter(driverListingView)
    }
}