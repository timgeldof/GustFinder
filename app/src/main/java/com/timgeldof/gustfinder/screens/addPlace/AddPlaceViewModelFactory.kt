package com.timgeldof.gustfinder.screens.addPlace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.GustRepository
/**
 * A subclass of [ViewModelProvider] Factory interface
 */
class AddPlaceViewModelFactory(
    private val repository: GustRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddPlaceViewModel::class.java)) {
            return AddPlaceViewModel(repository) as T
        }
        throw IllegalArgumentException("No such ViewModel class found")
    }
}