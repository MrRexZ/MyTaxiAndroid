package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.DriverList
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverOverviewPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverOverviewContract
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverListingFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.driver_overview_activity.*
import timber.log.Timber
import javax.inject.Inject

class DriverOverviewActivity : BaseActivity(),
    DriverOverviewContract.DriverOverviewView, HasSupportFragmentInjector {


    companion object {
        const val COOR1_KEY = "coor1_key"
        const val COOR2_KEY = "coor2_key"

        fun startDriverOverviewActivity(
            context: Context,
            lat1: Double,
            lon1: Double,
            lat2: Double,
            lon2: Double
        ): Intent {
            val intent = Intent(context, DriverOverviewActivity::class.java)
            intent.putExtra(COOR1_KEY, Coordinate(lat1, lon1))
            intent.putExtra(COOR2_KEY, Coordinate(lat2, lon2))
            return intent
        }
    }

    @Inject
    lateinit var presenter: DriverOverviewPresenter

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.driver_overview_activity)
        presenter.onViewCreated()
        requestTestDriverData()
    }

    fun requestTestDriverData() {
        var coor1: Coordinate = intent.extras.get(COOR1_KEY) as Coordinate
        var coor2: Coordinate = intent.extras.get(COOR2_KEY) as Coordinate
        presenter.requestDriverData(coor1, coor2)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun navigateToDeliveryListFragment() {
        var coor1: Coordinate = intent.extras.get(COOR1_KEY) as Coordinate
        var coor2: Coordinate = intent.extras.get(COOR2_KEY) as Coordinate
        var driverListFragment: Fragment = DriverListingFragment.onNewInstance(coor1, coor2)
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.driver_overview_root, driverListFragment)
        transaction.commit()
    }

    override fun showLoading() {
        driver_overview_progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        driver_overview_progressBar.visibility = View.GONE
    }

    override fun onDriverDataFetchSuccess(driverDataResp: DriverList) {
        Timber.d("Driver data fetch success")
        navigateToDeliveryListFragment()
    }

    override fun onDriverDataFetchFailed(error: String) {
        Timber.e(error)
    }



    override fun onDriverDataAvailable(driverDbList: List<DriverDb>) {
        Timber.d("Driver data loaded successfully")
    }
}