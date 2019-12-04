package com.timgeldof.gustfinder.screens.userMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
/**
 * A [ViewModel] subclass
 * @param database a [PlaceDatabaseDao] instance that is used to set the user places (myPlaces [LiveData])
 */
class UserMapViewModel(val database: PlaceDatabaseDao) : ViewModel() {

    private var _myPlaces: LiveData<List<Place>>
    val myPlaces: LiveData<List<Place>>
        get() = _myPlaces

    init {
        _myPlaces = database.getAllPlaces()
    }
}