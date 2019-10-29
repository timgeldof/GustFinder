package com.timgeldof.gustfinder.screens.place_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import java.lang.IllegalArgumentException
import javax.sql.CommonDataSource

class PlaceDetailViewModelFactory(private val placeKey:Long = 0L, private val dataSource: PlaceDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PlaceDetailViewModel::class.java)){
            return PlaceDetailViewModel(placeKey, dataSource) as T
        }
        throw IllegalArgumentException("unknown viewmodel class")
    }
}