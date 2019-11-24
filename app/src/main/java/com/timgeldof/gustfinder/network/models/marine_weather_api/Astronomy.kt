package com.timgeldof.gustfinder.network.models.marine_weather_api


data class Astronomy (

	val sunrise : String,
	val sunset : String,
	val moonrise : String,
	val moonset : String,
	val moon_phase : String,
	val moon_illumination : Int
)