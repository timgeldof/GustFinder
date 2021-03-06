package com.timgeldof.gustfinder.network.models.marineWeatherApi

import com.timgeldof.gustfinder.database.realm.RealmWeatherIconUrl
import io.realm.RealmList

/**
 * Contains hourly information used in the [Weather] class
 */
data class Hourly(

    val time: Int?,
    val tempC: Int?, // relevant
    val tempF: Int?,
    val windspeedMiles: Int?,
    val windspeedKmph: Int, // relevant
    val winddirDegree: Int?,
    val winddir16Point: String, // relevant
    val weatherCode: Int?,
    val weatherIconUrl: List<WeatherIconUrl>, // relevant
    val weatherDesc: List<WeatherDesc>?,
    val precipMM: Double?,
    val precipInches: Double?,
    val humidity: Int?,
    val visibility: Int?,
    val visibilityMiles: Int?,
    val pressure: Int?,
    val pressureInches: Int?,
    val cloudcover: Int?,
    val heatIndexC: Int?,
    val heatIndexF: Int?,
    val dewPointC: Int?,
    val dewPointF: Int?,
    val windChillC: Int?,
    val windChillF: Int?,
    val windGustMiles: Int?,
    val windGustKmph: Int?, // relevant
    val feelsLikeC: Int?,
    val feelsLikeF: Int?,
    val sigHeight_m: Double?,
    val swellHeight_m: Double?, // relevant
    val swellHeight_ft: Double?,
    val swellDir: Int?,
    val swellDir16Point: String?, // relevant
    val swellPeriod_secs: Double?, // relevant
    val waterTemp_C: Int?,
    val waterTemp_F: Int?
) {
    fun getTempFormatted(): String {
        return tempC.toString() + " °C"
    }
    fun getWindSpeedFormatted(): String {
        return "$windspeedKmph km/h"
    }
    fun getWindDir16point(): String {
        return winddir16Point
    }
    fun getWeatherIconUrl(): String {
        return weatherIconUrl[0].value
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
            return swellDir16Point
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
                "Swell direction: " + getSwellDir16point() + "\n"
    }
    fun weatherIconUrlAsRealm(): RealmList<RealmWeatherIconUrl> {
        val realmWeatherIcon = RealmList<RealmWeatherIconUrl>()
        realmWeatherIcon.add(RealmWeatherIconUrl(this.weatherIconUrl[0].value))
        return realmWeatherIcon
    }
}