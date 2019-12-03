package com.timgeldof.gustfinder.network.models.marineWeatherApi

data class Weather(
    val date: String,
    val astronomy: List<Astronomy>?,
    val maxtempC: Int,
    val maxtempF: Int,
    val mintempC: Int,
    val mintempF: Int,
    val hourly: List<Hourly>
) {
    fun getMinTempFormatted(): String {
        return "$mintempC °C"
    }
    fun getMaxTempFormatted(): String {
        return "$maxtempC °C"
    }
}