package com.example.mrrexz.mytaxiandroid.di.component

import com.example.mrrexz.mytaxiandroid.base.MyTaxiApp
import com.example.mrrexz.mytaxiandroid.di.module.AppModule
import com.example.mrrexz.mytaxiandroid.di.module.BaseActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class, BaseActivityModule::class))
interface AppComponent {

    fun inject(application: MyTaxiApp)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun baseApp(app: MyTaxiApp) : Builder
    }
}