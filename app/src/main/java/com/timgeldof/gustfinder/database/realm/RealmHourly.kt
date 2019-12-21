package com.timgeldof.gustfinder.database.realm

import com.timgeldof.gustfinder.network.models.marineWeatherApi.WeatherDesc
import com.timgeldof.gustfinder.network.models.marineWeatherApi.WeatherIconUrl
import io.realm.RealmList
import io.realm.RealmObject

open class RealmHourly(
    var time: Int?,
    var tempC: Int?, // relevant
    var windspeedKmph: Int, // relevant
    var winddir16Point: String?, // relevant
    var weatherIconUrl: RealmList<RealmWeatherIconUrl>, // relevant
    var windGustKmph: Int?, // relevant
    var swellHeight_m: Double?, // relevant
    var swellDir16Point: String?, // relevant
    var swellPeriod_secs: Double?, // relevant
    var waterTemp_C: Int? // relevant
): RealmObject() {

    constructor(): this(0,0,0,"",RealmList<RealmWeatherIconUrl>(),0,0.0,null,0.0,null)


    fun getTempFormatted(): String {
        return tempC.toString() + " °C"
    }
    fun getWaterTempFormatted(): String {
        return waterTemp_C.toString() + " °C"
    }

    fun getWindSpeedFormatted(): String {
        return "$windspeedKmph km/h"
    }

    fun getWindDir16point(): String {
        return winddir16Point!!
    }

    fun getWeatherIconUrl(): String {
        return weatherIconUrl[0]!!.value
    }

    fun getWindGustFormatted(): String {
        if (windGustKmph != null)
            return "$windGustKmph km/h"
        else return "-"
    }

    fun getSwellHeightFormatted(): String {
        return swellHeight_m.toString() + " m"
    }

    fun getSwellDir16point(): String {
        if (swellDir16Point != null)
            return swellDir16Point!!
        else
            return "-"
    }

    fun getSwellPeriodFormatted(): String {
        return swellPeriod_secs.toString() + " s"
    }

    /**
     * Returns weather statistics relevant to a surfer/user of the app
     *
     * @return A formatted string containing the weather statistics for the hour
     */
    fun getSurfStatistics(): String {
        return "Temperature:  " + getTempFormatted() + "\n" +
                "Wind speed: " + getWindSpeedFormatted() + "\n" +
                "Wind direction: " + getWindDir16point() + "\n" +
                "Wind gust speed: " + getWindGustFormatted() + "\n" +
                "Swell height: " + getSwellHeightFormatted() + "\n" +
                "Swell direction: " + getSwellDir16point() + "\n"+
                "Water temperature: " + getWaterTempFormatted() + "\n"
    }
}