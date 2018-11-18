package com.example.mrrexz.mytaxiandroid.di.component

import com.example.mrrexz.mytaxiandroid.base.MyTaxiApp
import com.example.mrrexz.mytaxiandroid.di.module.*
import com.example.mrrexz.mytaxiandroid.features.main.ui.MainActivity
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class))
interface AppComponent {

    fun inject(application: MyTaxiApp)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun baseApp(app: MyTaxiApp) : Builder
    }
}