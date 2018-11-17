package com.example.mrrexz.mytaxiandroid.di.module

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.base.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDriversApi(retrofit: Retrofit) : DriversApi {
        return retrofit.create(DriversApi::class.java)

    }

}