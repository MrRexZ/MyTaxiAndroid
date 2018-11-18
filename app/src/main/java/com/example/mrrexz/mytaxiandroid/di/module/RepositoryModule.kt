package com.example.mrrexz.mytaxiandroid.di.module

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDriverRepo(driversApi: DriversApi): DriverRepository {
        return DriverRepository(driversApi)
    }
}