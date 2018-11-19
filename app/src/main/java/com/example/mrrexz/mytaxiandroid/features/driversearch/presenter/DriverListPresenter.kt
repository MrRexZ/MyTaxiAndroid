package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter

import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.presenter.contract.DriverListingContract
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class DriverListPresenter(
    driverListingView: DriverListingContract.DriverListingView,
    private var driverRepo: DriverRepository
) : BasePresenter<DriverListingContract.DriverListingView>(driverListingView),
    DriverListingContract.DriverListingPresenter {


    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated() {
    }


    override fun observeDriverData(coor1: Coordinate, coor2: Coordinate) {
        view.showLoading()
        val subscription = driverRepo.getDrivers(DriversReq(coor1.lat, coor1.lon, coor2.lat, coor2.lon))
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate { view.hideLoading() }
            .subscribe({ driverListDb ->
                run {
                    view.onDriverDataAvailable(driverListDb)
                }
            }, {
                view.onDriverDataFetchFailed("DriverFetchError: " + it.message)
            })

        compositeDisposable.add(subscription)
    }

    override fun onViewDestroyed() {
        compositeDisposable.dispose()
    }
}