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
import io.realm.Realm
import io.realm.RealmConfiguration
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
        initInjection()
        initRealm()
    }

    fun initInjection() {
        appComponent = DaggerAppComponent.builder().baseApp(this).build()
        appComponent.inject(this)
    }
    fun initRealm() {
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(realmConfig)
    }


}