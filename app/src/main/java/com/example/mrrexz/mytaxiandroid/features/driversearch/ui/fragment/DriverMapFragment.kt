package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverMapContract
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.driver_map_fragment.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng



class DriverMapFragment : BaseFragment(), DriverMapContract.DriverMapView, OnMapReadyCallback {
    var gMap : GoogleMap? = null
    override fun onMapReady(p0: GoogleMap?) {
        gMap = p0
    }

    companion object {
        const val DRIVER_ID_KEY = "DRIVER_ID_KEY"
        fun onNewInstance(id : String) : DriverMapFragment {
            val bundle = Bundle()
            bundle.putString(DRIVER_ID_KEY, id)
            val fragment = DriverMapFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.driver_map_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGoogleMap()
    }

    fun initGoogleMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.driver_map_gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun loadDriverDataOnMap() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadDriverDataFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}