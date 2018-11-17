package com.example.mrrexz.mytaxiandroid.di.module

import com.example.mrrexz.mytaxiandroid.features.main.di.MainActivityModule
import com.example.mrrexz.mytaxiandroid.features.main.di.MainActivityViewModule
import com.example.mrrexz.mytaxiandroid.features.main.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {


    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityViewModule::class])
    abstract fun mainActivity() : MainActivity



}