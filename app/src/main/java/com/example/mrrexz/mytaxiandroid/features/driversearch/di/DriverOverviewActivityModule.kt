package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import android.content.Context
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverListPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverListingView
import dagger.Module
import dagger.Provides

@Module
class DriverOverviewActivityModule {

    @Provides
    fun provideDriverListPresenter(driverListingView: DriverListingView) : DriverListPresenter {
        return DriverListPresenter(driverListingView)
    }

    @Provides
    fun provideDriverOverviewActContext(driverOverviewActivity: DriverOverviewActivity) : Context {
        return driverOverviewActivity
    }

}