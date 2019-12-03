package com.timgeldof.gustfinder.network.models.marineWeatherApi
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
}