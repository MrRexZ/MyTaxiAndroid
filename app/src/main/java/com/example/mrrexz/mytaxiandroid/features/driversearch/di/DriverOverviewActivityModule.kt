package com.example.mrrexz.mytaxiandroid.features.driversearch.di

import android.content.Context
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverOverviewPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverOverviewContract
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DriverOverviewActivityModule {


    @Provides
    fun provideDriverOverviewActContext(driverOverviewActivity: DriverOverviewActivity) : Context {
        return driverOverviewActivity
    }


    @Provides
    fun provideDOP(driverOverviewView: DriverOverviewContract.DriverOverviewView,
                   @Named("realmDriverRepo") driverRepo : DriverRepository) : DriverOverviewPresenter {
        return DriverOverviewPresenter(driverOverviewView, driverRepo)
    }

}