package com.example.mrrexz.mytaxiandroid.features.main.di

import com.example.mrrexz.mytaxiandroid.base.view.BaseView
import com.example.mrrexz.mytaxiandroid.features.main.presenter.MainPresenter
import com.example.mrrexz.mytaxiandroid.features.main.ui.MainActivity
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainPresenter(mainView: MainView) : MainPresenter {
        return MainPresenter(mainView)
    }


}