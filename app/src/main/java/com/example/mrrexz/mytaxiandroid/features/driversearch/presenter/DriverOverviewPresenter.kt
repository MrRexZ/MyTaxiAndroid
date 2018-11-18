package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter

import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverOverviewContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DriverOverviewPresenter(
    driverOverviewView: DriverOverviewContract.DriverOverviewView,
    var driverRepo: DriverRepository
) : BasePresenter<DriverOverviewContract.DriverOverviewView>(driverOverviewView)
    , DriverOverviewContract.DriverOverviewPresenter {


    override fun requestDriverData(coor1: Coordinate, coor2: Coordinate) {
        loadDriversDetails(DriversReq(coor1.lat, coor1.lon, coor2.lat, coor2.lon))
    }

    init {

    }


    var subscription: Disposable? = null
    override fun onViewCreated() {
    }

    private fun loadDriversDetails(driverReq: DriversReq) {
        subscription = driverRepo.getDriversFromNetwork(driverReq)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { driverListResp ->
                    run {
                        view.onDriverDataFetchSuccess(driverListResp)
                        driverRepo.deleteAllDrivers(driverReq)
                        driverRepo.insertDrivers(driverReq, driverListResp)
                    }
                },
                { view.onDriverDataFetchFailed("Error fetching driver details") }
            )
    }

    override fun observeDriverData(coor1: Coordinate, coor2: Coordinate) {
        view.showLoading()
        subscription = driverRepo.getDrivers(DriversReq(coor1.lat, coor1.lon, coor2.lat, coor2.lon))
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate { view.hideLoading() }
            .subscribe({ driverListDb ->
                run {
                    view.onDriverDataAvailable(driverListDb)
                }
            }, {
                view.onDriverDataFetchFailed("Error loading driver data")
            })
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}