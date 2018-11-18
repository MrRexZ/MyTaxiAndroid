package com.example.mrrexz.mytaxiandroid.features.main.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import com.example.mrrexz.mytaxiandroid.features.main.presenter.MainPresenter
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {


    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListener()
    }


    internal fun setClickListener() {
        main_screen_show_drivers_list_button.setOnClickListener {
            onShowDriverListSelected()
        }
    }




    internal fun navigateToDriverOverview() {
        startActivity(DriverOverviewActivity.startDriverOverviewActivity(this, 53.694865, 9.757589,
            53.394655, 10.099891))
    }

    override fun onShowDriverListSelected() {
        navigateToDriverOverview()
    }



}
