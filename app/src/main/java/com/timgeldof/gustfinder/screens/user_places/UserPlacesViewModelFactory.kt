package com.timgeldof.gustfinder.screens.user_places

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.PlaceDatabaseDao

class UserPlacesViewModelFactory (
    private val dataSource: PlaceDatabaseDao,
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserPlacesViewModel::class.java)){
            return UserPlacesViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }

}