package com.example.mrrexz.mytaxiandroid.features.driversearch.presenter

import com.example.mrrexz.mytaxiandroid.base.presenter.BasePresenter
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import com.example.mrrexz.mytaxiandroid.features.driversearch.ui.view.DriverOverviewView
import com.example.mrrexz.mytaxiandroid.model.DriverRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DriverOverviewPresenter(driverOverviewView: DriverOverviewView) : BasePresenter<DriverOverviewView>(driverOverviewView) {
    @Inject
    lateinit var driverRepo : DriverRepository


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