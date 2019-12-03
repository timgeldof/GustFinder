package com.timgeldof.gustfinder.network.models.marineWeatherApi

/**
 * Contains information about the API request
 */
data class Request(
    val type: String,
    val query: String
)