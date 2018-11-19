package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter

import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.vo.Driver
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverMapContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class DriverMapPresenter(driverMapView: DriverMapContract.DriverMapView, var driverRepo: DriverRepository) :
    BasePresenter<DriverMapContract.DriverMapView>(driverMapView), DriverMapContract.DriverMapPresenter {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated() {
    }

    override fun onViewDestroyed() {
        compositeDisposable.dispose()
    }

    fun convertToDriver(listDriverDb: List<DriverDb>): List<Driver> {
        var driversList: MutableList<Driver> = mutableListOf()
        for (driverDb in listDriverDb) {
            var driver = Driver(
                driverDb.id,
                Coordinate(driverDb.driverCoordLat, driverDb.driverCoordLon),
                driverDb.fleetType,
                driverDb.heading
            )
            driversList.add(driver)
        }
        return driversList
    }

    override fun displayDriverDataOnMap(coor1: Coordinate, coor2: Coordinate) {
        var subscription = driverRepo.getDrivers(DriversReq(coor1.lat, coor1.lon, coor2.lat, coor2.lon))
            .map { listDriverDb -> convertToDriver(listDriverDb) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                run {
                    view.loadDriverDataOnMap(it)
                }
            }, {
                view.loadDriverDataFailed("Error loading data to map : " + it.message)
            })


        compositeDisposable.add(subscription)
    }
}