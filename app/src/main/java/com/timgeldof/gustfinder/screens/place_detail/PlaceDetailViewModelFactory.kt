package com.timgeldof.gustfinder.screens.place_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import java.lang.IllegalArgumentException
import javax.sql.CommonDataSource

class PlaceDetailViewModelFactory(private val place: Place) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PlaceDetailViewModel::class.java)){
            return PlaceDetailViewModel(place) as T
        }
        throw IllegalArgumentException("unknown viewmodel class")
    }
}