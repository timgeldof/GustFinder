package com.timgeldof.gustfinder.screens.userPlaces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.PlaceDatabaseDao

class UserPlacesViewModelFactory(
    private val dataSource: PlaceDatabaseDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserPlacesViewModel::class.java)) {
            return UserPlacesViewModel(dataSource) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }
}