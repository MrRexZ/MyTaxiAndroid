package com.example.mrrexz.mytaxiandroid.features.main.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import com.example.mrrexz.mytaxiandroid.features.main.presenter.MainPresenter
import com.example.mrrexz.mytaxiandroid.features.main.view.MainView
import com.example.mrrexz.mytaxiandroid.util.isValidLatLng
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.time.Duration
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
        main_screen_reset_lat_lng.setOnClickListener {
            main_screen_lat1_et.setText(53.694865.toString())
            main_screen_lon1_et.setText(9.757589.toString())
            main_screen_lat2_et.setText(53.394655.toString())
            main_screen_lon2_et.setText(10.099891.toString())
        }
    }




    internal fun navigateToDriverOverview(lat1 : Double?, lon1 : Double?, lat2 : Double?, lon2: Double?) {
        startActivity(DriverOverviewActivity.startDriverOverviewActivity(this, lat1, lon1,
            lat2, lon2))
    }

    override fun onShowDriverListSelected() {
        val lat1 = main_screen_lat1_et.text.toString().toDoubleOrNull()
        val lon1 = main_screen_lon1_et.text.toString().toDoubleOrNull()
        val lat2 = main_screen_lat2_et.text.toString().toDoubleOrNull()
        val lon2 = main_screen_lon2_et.text.toString().toDoubleOrNull()
        if (isValidLatLng(lat1, lon1) && isValidLatLng(lat2, lon2)) {
            navigateToDriverOverview(lat1, lon1, lat2, lon2)
        } else {
            Toast.makeText(this, "LatLng inputted is invalid.. Please check the input box above again.", Toast.LENGTH_LONG).show()
        }
    }



}
