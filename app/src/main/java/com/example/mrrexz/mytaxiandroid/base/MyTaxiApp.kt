package com.example.mrrexz.mytaxiandroid.base

import android.app.Activity
import android.app.Application
import com.example.mrrexz.mytaxiandroid.di.component.AppComponent
import com.example.mrrexz.mytaxiandroid.di.component.DaggerAppComponent
import com.example.mrrexz.mytaxiandroid.di.module.ContextModule
import com.example.mrrexz.mytaxiandroid.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class MyTaxiApp : Application(), HasActivityInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    lateinit var appComponent: AppComponent
    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector;
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().baseApp(this).contextModule(ContextModule).netModule(NetworkModule).build()
        appComponent.inject(this)
    }


}