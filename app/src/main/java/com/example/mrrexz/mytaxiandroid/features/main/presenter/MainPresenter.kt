package com.example.mrrexz.mytaxiandroid.features.main.presenter

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import javax.inject.Inject

class MainPresenter(mainView: MainView) : BasePresenter<MainView>(mainView) {
    @Inject
    lateinit var driversApi: DriversApi

    override fun onViewCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewDestroyed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}