package com.example.mrrexz.mytaxiandroid.features.main.di

import com.example.mrrexz.mytaxiandroid.base.view.BaseView
import com.example.mrrexz.mytaxiandroid.features.main.ui.MainActivity
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityViewModule {

    @Binds
    abstract fun bindsMainView(mainActivity : MainActivity) : MainView

}