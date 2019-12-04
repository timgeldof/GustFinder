package com.timgeldof.gustfinder.screens.userPlaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch

/**
 * Subclass of the [ViewModel] class
 */
class UserPlacesViewModel(val database: PlaceDatabaseDao) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToSelectedPlace = MutableLiveData<Place>()
    val navigateToSelectedPlace: LiveData<Place>
        get() = _navigateToSelectedPlace

    private var _myPlaces: LiveData<List<Place>>
    val myPlaces: LiveData<List<Place>>
            get() = _myPlaces

    init {
        _myPlaces = database.getAllPlaces()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    /**
     * Sets the navigation [LiveData] which triggers a navigation in the fragment when changed
     */
    fun displayPlaceDetails(place: Place) {
        _navigateToSelectedPlace.value = place
    }
    /**
     * Resets the navigation [LiveData] which triggers a navigation in the fragment when changed
     */
    fun displayPlaceDetailsComplete() {
        _navigateToSelectedPlace.value = null
    }
    /**
     * Remove a place from the user_places table within the IO coroutine context
     * @param place the place to be removed
     */
    private suspend fun removePlace(place: Place) {
        withContext(Dispatchers.IO) {
            database.removePlace(place.placeId)
        }
    }
    /**
     * Fetches the places from the database and sets it to the value of the _myPlaces [LiveData] property within a coroutine
     */
    fun getPlacesFromDB() {
        uiScope.launch {
            _myPlaces = database.getAllPlaces()
        }
    }
    /**
     * Removes the place from database user_places table within a coroutine
     * @param place the place to be removed
     */
    fun removePlaceFromDatabase(place: Place) {
        uiScope.launch {
            removePlace(place)
        }
    }
}