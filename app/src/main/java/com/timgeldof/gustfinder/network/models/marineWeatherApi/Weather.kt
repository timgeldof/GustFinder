package com.timgeldof.gustfinder.network.models.marineWeatherApi

import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.realm.RealmHourly
import com.timgeldof.gustfinder.database.realm.RealmPlaceEntity
import com.timgeldof.gustfinder.database.realm.RealmWeather
import io.realm.RealmList
import java.util.*

/**
 * Contains the current weather information for every couple of hours (depending on the API setting) for the weather of a certain date
 */
data class Weather(
    val date: String,
    val astronomy: List<Astronomy>?,
    val maxtempC: Int,
    val maxtempF: Int,
    val mintempC: Int,
    val mintempF: Int,
    val hourly: List<Hourly>
) {
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
    fun weatherAsRealmModel(place: Place): RealmWeather{
        return RealmWeather(place.latitude+"_"+place.longitude+"_"+date,null,this.maxtempC,this.maxtempF,this.mintempC,this.mintempF, hourlyAsRealmModel(), Date())
    }


    fun hourlyAsRealmModel(): RealmList<RealmHourly> {
        val realmList = RealmList<RealmHourly>()
        for (hourly in this.hourly) {
            realmList.add(RealmHourly(hourly.time,hourly.tempC,hourly.windspeedKmph,hourly.winddir16Point, hourly.weatherIconUrlAsRealm(),hourly.windGustKmph,hourly.swellHeight_m,hourly.swellDir16Point,hourly.swellPeriod_secs, hourly.waterTemp_C))
        }
        return realmList
    }
}