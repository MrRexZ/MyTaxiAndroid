package com.example.mrrexz.mytaxiandroid.base.presenter

import com.example.mrrexz.mytaxiandroid.base.view.BaseView

abstract class BasePresenter<out V : BaseView>(protected val view : V) {

    abstract fun onViewCreated()
    abstract fun onViewDestroyed()
}