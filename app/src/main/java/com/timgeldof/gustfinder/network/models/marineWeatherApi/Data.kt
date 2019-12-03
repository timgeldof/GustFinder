package com.timgeldof.gustfinder.network.models.marineWeatherApi

data class Data(

    val request: List<Request>,
    val weather: List<Weather>
)