package com.timgeldof.gustfinder.screens.place_detail

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import com.timgeldof.gustfinder.network.models.marine_weather_api.Weather
import com.timgeldof.gustfinder.network.service.GustFinderApi
import com.timgeldof.gustfinder.network.service.GustFinderApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class PlaceDetailViewModel(val place: Place) : ViewModel(){

    private var viewModelJob = Job()
    private val uiScope  = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _weather = MutableLiveData<List<Weather>>()

    val weather: LiveData<List<Weather>>
        get()= _weather

    init{
        getForecasts()
    }

    fun getForecasts(){
        val latAndLon = place.latitude + "," + place.longitude
        uiScope.launch {
            try{
                _weather.value = GustFinderApi.retrofitService.getForecastAsync(latAndLon).await().data.weather
                Log.i("API", "Amount of days fetched for forecast: " + weather.value!!.size.toString())
            } catch (t: Throwable){
                Log.i("API",t.message)
            }
        }
    }

}