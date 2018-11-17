package com.example.mrrexz.mytaxiandroid.di.module

import android.content.Context
import com.example.mrrexz.mytaxiandroid.base.BaseView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ContextModule {

    @Provides
    @Singleton
    @JvmStatic
    internal fun provideContext(bView : BaseView) : Context {
        return bView.getContext()
    }



}