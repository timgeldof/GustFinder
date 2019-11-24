package com.timgeldof.gustfinder.screens.place_detail

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import com.timgeldof.gustfinder.network.service.GustFinderApi
import com.timgeldof.gustfinder.network.service.GustFinderApiService
import retrofit2.Retrofit

class PlaceDetailViewModel(val place: Place) : ViewModel(){


    fun getForecasts(){
        val latAndLon = place.latitude + "," + place.longitude
        GustFinderApi.retrofitService.getForecastAsync(latAndLon)
    }

}