package com.timgeldof.gustfinder.database.realm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date

open class RealmWeather(
    @PrimaryKey
    var latLonDateKey: String,
    var astronomy: RealmList<RealmAstronomy>?,
    var maxtempC: Int,
    var maxtempF: Int,
    var mintempC: Int,
    var mintempF: Int,
    var hourly: RealmList<RealmHourly>,
    var created: Date
) : RealmObject() {

    constructor() : this("", null, 0, 0, 0, 0, RealmList<RealmHourly>(), Date())
    /**
     * Returns the minimum temperature for the day in celcius
     * @return the minimum temperature for the day in celcius
     */
    fun getMinTempFormatted(): String {
        return "$mintempC °C"
    }
    fun getMaxTempFormatted(): String {
        return "$maxtempC °C"
    }
    fun getDate(): String {
        return latLonDateKey.split("_").last()
    }
}