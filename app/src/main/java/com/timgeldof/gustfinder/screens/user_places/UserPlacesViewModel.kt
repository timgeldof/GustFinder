package com.timgeldof.gustfinder.screens.user_places

import android.app.Application
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.*
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import kotlinx.coroutines.*
import java.lang.StringBuilder

class UserPlacesViewModel(val database:PlaceDatabaseDao, application: Application): AndroidViewModel(application) {

    private var _myPlaces : LiveData<List<Place>>
    private var viewModelJob = Job()
    private val uiScope  = CoroutineScope(Dispatchers.Main + viewModelJob)



    val myPlaces: LiveData<List<Place>>
            get() = _myPlaces
    private val place1 = Place(area = "Wenduine", region = "West-Vlaanderen",country = "BEL",longitude = "51.300", latitude = "3.083")

    init{
        Log.i("UserPlacesViewModel", "Init called")
        _myPlaces = database.getAllPlaces()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Log.i("UserPlacesViewModel","OnCleared called")
    }


    fun getPlacesFromDB(){
        uiScope.launch {
            _myPlaces = database.getAllPlaces()
        }
    }

    fun removeAllPlacesFromDatabase(){
        uiScope.launch {
            clear()
        }
    }

    private suspend fun insert(place: Place){
        withContext(Dispatchers.IO){
            database.insert(place)
        }
    }

    private suspend fun clear(){
        withContext(Dispatchers.IO){
            database.clear()
        }
    }
    val placesString = Transformations.map(myPlaces){
        places -> formatPlaces(places, application.resources)
    }

    fun formatPlaces(places: List<Place>, resources:Resources):Spanned {
        val stringBuilder = StringBuilder()
        stringBuilder.apply {
            places.forEach { place ->
                append(place.area)
                append("<br>")
                append(place.country)
                append("<br>")
            }
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return Html.fromHtml(stringBuilder.toString(), Html.FROM_HTML_MODE_LEGACY)
        else
            return HtmlCompat.fromHtml(stringBuilder.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}