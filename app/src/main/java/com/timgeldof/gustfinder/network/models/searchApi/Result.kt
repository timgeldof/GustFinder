package com.timgeldof.gustfinder.network.models.searchApi
/**
 * The Search API location result for the given query parameters
 */
data class Result(

    val areaName: List<AreaName>,
    val country: List<Country>,
    val region: List<Region>,
    val latitude: String,
    val longitude: String,
    val population: Int,
    val weatherUrl: List<WeatherUrl>
) {
    fun getArea(): String {
        return areaName[0].value
    }
    fun getCountry(): String {
        return country[0].value
    }
    fun getRegion(): String {
        return region[0].value
    }
    fun getLon(): String {
        return longitude
    }
    fun getLat(): String {
        return latitude
    }
}