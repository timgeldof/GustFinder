package com.timgeldof.gustfinder.screens.userPlaces

import android.app.Application
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class UserPlacesViewModel(val database: PlaceDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToSelectedPlace = MutableLiveData<Place>()
    val navigateToSelectedPlace: LiveData<Place>
        get() = _navigateToSelectedPlace

    private var _myPlaces: LiveData<List<Place>>
    val myPlaces: LiveData<List<Place>>
            get() = _myPlaces

    init {
        Log.i("UserPlacesViewModel", "Init called")
        _myPlaces = database.getAllPlaces()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Log.i("UserPlacesViewModel", "OnCleared called")
    }
    fun displayPlaceDetails(place: Place) {
        _navigateToSelectedPlace.value = place
    }
    fun displayPlaceDetailsComplete() {
        _navigateToSelectedPlace.value = null
    }

    private suspend fun insert(place: Place) {
        withContext(Dispatchers.IO) {
            database.insert(place)
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
    private suspend fun removePlace(place: Place) {
        withContext(Dispatchers.IO) {
            database.removePlace(place.placeId)
        }
    }
    val placesString = Transformations.map(myPlaces) {
        places -> formatPlaces(places, application.resources)
    }

    fun formatPlaces(places: List<Place>, resources: Resources): Spanned {
        val stringBuilder = StringBuilder()
        stringBuilder.apply {
            places.forEach { place ->
                append(place.area)
                append("<br>")
                append(place.country)
                append("<br>")
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return Html.fromHtml(stringBuilder.toString(), Html.FROM_HTML_MODE_LEGACY)
        else
            return HtmlCompat.fromHtml(stringBuilder.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    fun getPlacesFromDB() {
        uiScope.launch {
            _myPlaces = database.getAllPlaces()
        }
    }

    fun removeAllPlacesFromDatabase() {
        uiScope.launch {
            clear()
        }
    }
    fun removePlaceFromDatabase(place: Place) {
        uiScope.launch {
            removePlace(place)
        }
    }
}