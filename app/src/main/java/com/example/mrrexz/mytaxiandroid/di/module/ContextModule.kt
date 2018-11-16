package com.example.mrrexz.mytaxiandroid.di.module

import android.content.Context
import com.example.mrrexz.mytaxiandroid.base.BaseView
import dagger.Module

@Module
object ContextModule {

    internal fun provideContext(bView : BaseView) : Context {
        return bView.getContext()
    }


}