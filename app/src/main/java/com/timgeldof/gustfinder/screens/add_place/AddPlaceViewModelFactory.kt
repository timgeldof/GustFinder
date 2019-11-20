package com.timgeldof.gustfinder.screens.add_place

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.PlaceDatabaseDao

class AddPlaceViewModelFactory (
    private val dataSource: PlaceDatabaseDao,
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddPlaceViewModel::class.java)){
            return AddPlaceViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }

}