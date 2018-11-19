package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverMapPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverMapContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DriverMapFragmentModule {

    @Provides
    fun provideDriverMapPresenter(driverMapView: DriverMapContract.DriverMapView, @Named("realmDriverRepo") driverRepo : DriverRepository) : DriverMapPresenter {
        return DriverMapPresenter(driverMapView, driverRepo)
    }
}