package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverListPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverListingContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DriverListingFragmentModule {

    @Provides
    fun provideDriverListPresenter(driverListingView: DriverListingContract.DriverListingView, @Named("realmDriverRepo") driverRepo : DriverRepository) : DriverListPresenter {
        return DriverListPresenter(driverListingView, driverRepo)
    }
}