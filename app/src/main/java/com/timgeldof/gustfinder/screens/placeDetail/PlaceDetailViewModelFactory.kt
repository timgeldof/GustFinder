package com.timgeldof.gustfinder.screens.placeDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timgeldof.gustfinder.database.Place
import java.lang.IllegalArgumentException
/**
 * A subclass of [ViewModelProvider] Factory interface
 */
class PlaceDetailViewModelFactory(private val place: Place) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlaceDetailViewModel::class.java)) {
            return PlaceDetailViewModel(place) as T
        }
        throw IllegalArgumentException("unknown viewmodel class")
    }
}