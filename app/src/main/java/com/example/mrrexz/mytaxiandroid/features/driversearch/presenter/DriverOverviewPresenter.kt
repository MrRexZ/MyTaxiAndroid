package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter

import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverOverviewContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DriverOverviewPresenter(
    driverOverviewView: DriverOverviewContract.DriverOverviewView,
    private var driverRepo: DriverRepository
) : BasePresenter<DriverOverviewContract.DriverOverviewView>(driverOverviewView)
    , DriverOverviewContract.DriverOverviewPresenter {


    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onViewCreated() {
    }

    private fun loadDriversDetails(driverReq: DriversReq) {
        val subscription = driverRepo.getDriversFromNetwork(driverReq)
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
                { view.onDriverDataFetchFailed("Error fetching driver details from endpoint :" + it.message) }
            )

        compositeDisposable.add(subscription)
    }


    override fun requestDriverData(coor1: Coordinate, coor2: Coordinate) {
        loadDriversDetails(DriversReq(coor1.lat, coor1.lon, coor2.lat, coor2.lon))
    }


    override fun onViewDestroyed() {
        compositeDisposable.dispose()
    }
}