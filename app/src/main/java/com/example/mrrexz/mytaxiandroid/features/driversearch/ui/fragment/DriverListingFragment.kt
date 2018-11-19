package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverListPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverListingContract
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.activity.DriverOverviewActivity
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.adapter.DriverListAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.driver_list_fragment.*
import timber.log.Timber
import javax.inject.Inject

class DriverListingFragment : BaseFragment(), DriverListingContract.DriverListingView,
    DriverListingContract.DriverListClickListener {
    companion object {

        const val COOR1_KEY = "coor1_key"
        const val COOR2_KEY = "coor2_key"

        fun onNewInstance(coor1: Coordinate, coor2: Coordinate): DriverListingFragment {
            val bundle = Bundle()
            bundle.putSerializable(COOR1_KEY, coor1)
            bundle.putSerializable(COOR2_KEY, coor2)
            val driverListingFragment = DriverListingFragment()
            driverListingFragment.arguments = bundle
            return driverListingFragment
        }
    }


    @Inject
    lateinit var presenter: DriverListPresenter
    private var driverListAdapter: DriverListAdapter? = null


    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.driver_list_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
        setAdapter()
        observeDriverData()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onViewDestroyed()
    }

    override fun onDriverListClick(driverId: String) {
        var coor1: Coordinate = arguments?.getSerializable(DriverOverviewActivity.COOR1_KEY) as Coordinate
        var coor2: Coordinate = arguments?.getSerializable(DriverOverviewActivity.COOR2_KEY) as Coordinate
        navigateToMapPage(driverId, coor1, coor2)
    }

    override fun navigateToMapPage(driverId: String, coor1Bound: Coordinate, coor2Bound: Coordinate) {

        if (activity?.supportFragmentManager?.findFragmentByTag(DriverMapFragment.toString()) == null) {
            val driverMapFragment = DriverMapFragment.onNewInstance(driverId, coor1Bound, coor2Bound)
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(android.R.id.content, driverMapFragment, DriverMapFragment.toString())?.addToBackStack(null)
                ?.commit()
        }
    }

    override fun observeDriverData() {
        var coor1: Coordinate = arguments?.getSerializable(DriverOverviewActivity.COOR1_KEY) as Coordinate
        var coor2: Coordinate = arguments?.getSerializable(DriverOverviewActivity.COOR2_KEY) as Coordinate
        presenter.observeDriverData(coor1, coor2)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onDriverDataAvailable(driverDbList: List<DriverDb>) {
        loadDataToAdapter(driverDbList)
    }

    override fun onDriverDataFetchFailed(error: String) {
        Toast.makeText(context, "Error loading driver data", Toast.LENGTH_LONG).show()
        Timber.e(error)
    }


    private fun setAdapter() {
        if (context != null) {
            var context = context!!
            driverListAdapter = DriverListAdapter(context, this)
            driver_list_fragment_rv.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            driver_list_fragment_rv.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            driver_list_fragment_rv.adapter = driverListAdapter
        }
    }

    private fun loadDataToAdapter(driverDbList: List<DriverDb>) {
        driverListAdapter?.updateDrivers(driverDbList)
    }

}