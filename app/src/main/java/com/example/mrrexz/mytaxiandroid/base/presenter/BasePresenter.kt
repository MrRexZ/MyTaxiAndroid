package com.example.mrrexz.mytaxiandroid.base.presenter

import com.example.mrrexz.mytaxiandroid.base.view.BaseActivityView

abstract class BasePresenter<out V : BaseActivityView>(protected val view : V) {


    abstract fun onViewCreated()
    abstract fun onViewDestroyed()
}