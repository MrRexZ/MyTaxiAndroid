package com.example.mrrexz.mytaxiandroid.model

import com.example.mrrexz.mytaxiandroid.api.DriversApi
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.Coordinate
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.db.DriverDb
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.DriverList
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.network.request.DriversReq
import io.reactivex.Flowable
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import io.realm.kotlin.createObject

class RealmDriverRepo(private var driverApi: DriversApi) : DriverRepository {

    override fun deleteAllDrivers(driverReq: DriversReq) {
        var realm = Realm.getDefaultInstance()
        var res : RealmResults<DriverDb> = realm.where(DriverDb::class.java).equalTo("searchCoor1Lat", driverReq.p1Lat).equalTo("searchCoor1Lon", driverReq.p1Lon)
            .equalTo("searchCoor2Lat", driverReq.p2Lat).equalTo("searchCoor2Lon", driverReq.p2Lon)
            .findAll()

        realm?.executeTransaction { res.deleteAllFromRealm() }
    }

    override fun insertDrivers(driverReq : DriversReq, driverList: DriverList) {

        var realm = Realm.getDefaultInstance()
        val driversResp = driverList.drivers
        realm.executeTransaction {
            for (driver in driversResp) {
                val driverDbObj = realm.createObject(DriverDb::class.java, driver.id)
                driverDbObj.searchCoor1Lat =driverReq.p1Lat
                driverDbObj.searchCoor1Lon =driverReq.p1Lon
                driverDbObj.searchCoor2Lat =driverReq.p2Lat
                driverDbObj.searchCoor2Lon =driverReq.p2Lon
                driverDbObj.driverCoordLat = driver.coordinate.latitude
                driverDbObj.driverCoordLon = driver.coordinate.longitude
                driverDbObj.fleetType = driver.fleetType
                driverDbObj.heading = driver.heading
            }
        }

    }

    override fun getDrivers(driverReq: DriversReq): Flowable<List<DriverDb>> {
        val realm = Realm.getDefaultInstance()
        var query: RealmQuery<DriverDb> = realm.where(DriverDb::class.java)
        var flowable: Flowable<RealmResults<DriverDb>>;
        flowable = query.equalTo("searchCoor1Lat", driverReq.p1Lat).equalTo("searchCoor1Lon", driverReq.p1Lon)
            .equalTo("searchCoor2Lat", driverReq.p2Lat).equalTo("searchCoor2Lon", driverReq.p2Lon)
            .findAll().asFlowable()
        return flowable as Flowable<List<DriverDb>>

    }

    override fun getDriversFromNetwork(driverReq: DriversReq): Observable<DriverList> {
        return driverApi.getDrivers(driverReq.p1Lat, driverReq.p1Lon, driverReq.p2Lat, driverReq.p2Lon)
    }
}