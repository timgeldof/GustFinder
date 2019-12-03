package com.timgeldof.gustfinder.network.models.marineWeatherApi

/**
 * Contains information about the conditions of the moon and the rising and setting of the sun
 */
data class Astronomy(

    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moon_phase: String,
    val moon_illumination: Int
)