package com.example.mrrexz.mytaxiandroid.features.main.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseActivity
import com.example.mrrexz.mytaxiandroid.features.main.presenter.MainPresenter
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {
    override fun onShowDriverListSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
