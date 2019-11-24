package com.timgeldof.gustfinder.network.models.marine_weather_api

data class Data (

	val request : List<Request>,
	val weather : List<Weather>
)