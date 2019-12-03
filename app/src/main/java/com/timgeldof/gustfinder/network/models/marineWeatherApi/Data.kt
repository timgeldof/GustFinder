package com.timgeldof.gustfinder.network.models.marineWeatherApi
/**
 * Contains information about both the api request as well as the content of the api response
 */
data class Data(

    val request: List<Request>,
    val weather: List<Weather>
)