package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.base.view.BaseFragment
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.vo.Driver
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.DriverMapPresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverMapContract
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.driver_map_fragment.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber
import javax.inject.Inject


class DriverMapFragment : BaseFragment(), DriverMapContract.DriverMapView, OnMapReadyCallback {
    override fun initMap() {
        initGoogleMap()
    }

    override fun renderCarIconOnMap(lat: Double, lon: Double, fleetType: String) {

        val bitmapDescriptorFactory : BitmapDescriptor
        if (fleetType == "POOLING") {
            bitmapDescriptorFactory = BitmapDescriptorFactory.fromResource(R.drawable.pooling_car_48)
        } else if (fleetType == "TAXI") {
            bitmapDescriptorFactory = BitmapDescriptorFactory.fromResource(R.drawable.taxi_car_48)
        } else {
            bitmapDescriptorFactory = BitmapDescriptorFactory.fromResource(R.drawable.pooling_car_48)
        }
        gMap?.addMarker(MarkerOptions().position(LatLng(lat, lon)).icon(bitmapDescriptorFactory))
    }

    override fun requestDisplayData(boundsCoor1: Coordinate, boundsCoor2: Coordinate) {
        driverMapPresenter.displayDriverDataOnMap(boundsCoor1, boundsCoor2)
    }


    override fun mapFocusOnLatLng(lat: Double, lon: Double) {
        gMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lat, lon), 15f))
    }

    private var gMap: GoogleMap? = null
    override fun onMapReady(p0: GoogleMap?) {
        gMap = p0
    }

    @Inject
    lateinit var driverMapPresenter: DriverMapPresenter

    companion object {
        const val DRIVER_ID_KEY = "DRIVER_ID_KEY"
        const val BOUNDS_COOR1 = "BOUNDS_COOR1"
        const val BOUNDS_COOR2 = "BOUNDS_COOR2"
        fun onNewInstance(id: String, coor1: Coordinate, coor2: Coordinate): DriverMapFragment {
            val bundle = Bundle()
            bundle.putString(DRIVER_ID_KEY, id)
            bundle.putSerializable(BOUNDS_COOR1, coor1)
            bundle.putSerializable(BOUNDS_COOR2, coor2)
            val fragment = DriverMapFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.driver_map_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coor1 = arguments?.getSerializable(BOUNDS_COOR1) as Coordinate
        val coor2 = arguments?.getSerializable(BOUNDS_COOR2) as Coordinate
        initMap()
        requestDisplayData(coor1, coor2)
    }

    private fun initGoogleMap() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.driver_map_gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun loadDriverDataOnMap(driverList: List<Driver>) {
        val driverIdToZoom = arguments?.getString(DRIVER_ID_KEY)
        for (driver in driverList) {
            if (driver.coord.lat != null && driver.coord.lon != null) {
                val lat: Double = driver.coord.lat
                val lon: Double = driver.coord.lon
                renderCarIconOnMap(lat, lon, driver.fleetType)
                if (driver.id == driverIdToZoom) {
                    mapFocusOnLatLng(lat, lon)
                }
            }
        }
    }

    override fun loadDriverDataFailed(err: String) {
        Timber.e(err)
    }


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}