package com.example.mrrexz.mytaxiandroid.base.view

import android.content.Context
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : BaseActivityView, AppCompatActivity() {
    override fun getContext(): Context {
        return this
    }

}