package com.timgeldof.gustfinder.screens.userMap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.PlaceDatabaseDao

class UserMapViewModelFactory(
    private val dataSource: PlaceDatabaseDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserMapViewModel::class.java)) {
            return UserMapViewModel(dataSource) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }
}