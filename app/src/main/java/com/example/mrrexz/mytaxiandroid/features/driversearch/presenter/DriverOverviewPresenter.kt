package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter

import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverOverviewContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.sql.Driver
import javax.inject.Inject

class DriverOverviewPresenter(driverOverviewView: DriverOverviewContract.DriverOverviewView, var driverRepo : DriverRepository) : BasePresenter<DriverOverviewContract.DriverOverviewView>(driverOverviewView)
, DriverOverviewContract.DriverOverviewPresenter{
    override fun requestDriverData(coor1: Coordinate, coor2: Coordinate) {
        loadDriversDetails(DriversReq(coor1.lat, coor1.long, coor2.lat, coor2.long))
    }

    init {

    }



    var subscription : Disposable? = null
    override fun onViewCreated() {
    }

    private fun loadDriversDetails(driverReq: DriversReq) {
        view.showLoading()
        subscription =  driverRepo.getDrivers(driverReq).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).doOnTerminate{ view.hideLoading() }
            .subscribe (
                { driverListResp -> view.onDriverDataFetchSuccess(driverListResp)},
                { view.onDriverDataFetchFailed("Unknown error")}
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}