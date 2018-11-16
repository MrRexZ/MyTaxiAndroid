package com.example.mrrexz.mytaxiandroid.di.module

import com.example.mrrexz.mytaxiandroid.ui.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BaseActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivity() : MainActivity
}