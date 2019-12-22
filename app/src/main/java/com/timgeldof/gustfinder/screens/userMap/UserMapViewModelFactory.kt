package com.timgeldof.gustfinder.screens.userMap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.GustRepository

class UserMapViewModelFactory(
    private val repository: GustRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserMapViewModel::class.java)) {
            return UserMapViewModel(repository) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }
}