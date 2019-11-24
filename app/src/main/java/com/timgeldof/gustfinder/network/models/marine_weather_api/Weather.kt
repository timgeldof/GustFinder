package com.timgeldof.gustfinder.network.models.marine_weather_api


data class Weather (
	val date : String,
	val astronomy : List<Astronomy>,
	val maxtempC : Int,
	val maxtempF : Int,
	val mintempC : Int,
	val mintempF : Int,
	val hourly : List<Hourly>
)