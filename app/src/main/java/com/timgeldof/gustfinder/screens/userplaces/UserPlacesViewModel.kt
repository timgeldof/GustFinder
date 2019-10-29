package com.timgeldof.gustfinder.screens.userplaces

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

    private var _myPlaces = database.getAllPlaces()
    private var viewModelJob = Job()
    private val uiScope  = CoroutineScope(Dispatchers.Main + viewModelJob)



    val myPlaces: LiveData<List<Place>>
            get() = _myPlaces

    init{
        Log.i("UserPlacesViewModel", "Init called")
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Log.i("UserPlacesViewModel","OnCleared called")
    }

    private val place1 = Place(city = "Wenduine", countryCodeISO = "BEL")


    fun addPlacesToDatabase(){
        uiScope.launch {
            insert(place1)
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
                append(place.city)
                append("<br>")
                append(place.countryCodeISO)
                append("<br>")
            }
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return Html.fromHtml(stringBuilder.toString(), Html.FROM_HTML_MODE_LEGACY)
        else
            return HtmlCompat.fromHtml(stringBuilder.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}