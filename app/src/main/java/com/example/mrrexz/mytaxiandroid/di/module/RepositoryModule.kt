package com.example.mrrexz.mytaxiandroid.di.module

import android.content.Context
import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import com.example.mrrexz.mytaxiandroid.model.RealmDriverRepo
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Singleton
    @Provides
    @Named("realmDriverRepo")
    fun provideRealmDriverRepo(driversApi: DriversApi): DriverRepository {
        return RealmDriverRepo(driversApi)
    }


}