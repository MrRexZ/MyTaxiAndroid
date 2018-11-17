package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment.DriverListingFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverOverviewView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.driver_overview_activity.view.*
import javax.inject.Inject

class DriverOverviewActivity : BaseActivity(), DriverOverviewView , HasSupportFragmentInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.driver_overview_activity)

    }

    internal fun navigateToDeliveryListFragment() {
        var driverListFragment : Fragment = DriverListingFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.driver_overview_root, driverListFragment)
        transaction.commit()
    }

    override fun showLoading() {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDriverDataFetchSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDriverDataFetchFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}