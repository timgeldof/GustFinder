package com.timgeldof.gustfinder.screens.userPlaces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.GustRepository

class UserPlacesViewModelFactory(
    private val repository: GustRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserPlacesViewModel::class.java)) {
            return UserPlacesViewModel(repository) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }
}