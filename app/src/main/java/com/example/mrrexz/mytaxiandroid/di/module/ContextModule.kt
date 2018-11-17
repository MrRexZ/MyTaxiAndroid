package com.example.mrrexz.mytaxiandroid.di.module

import android.content.Context
import com.example.mrrexz.mytaxiandroid.base.view.BaseActivityView
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.Nullable
import javax.inject.Singleton

@Module
object ContextModule {

    @Provides
    @Singleton
    @JvmStatic
    @Nullable
    internal fun provideContext(bView : BaseActivityView) : Context {
        return bView.getContext()
    }

    //TODO: Provide context from fragment here...



}