package com.timgeldof.gustfinder.screens.myplaces

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyPlacesViewModel: ViewModel() {

    private var _myPlaces = MutableLiveData<List<String>>()

    val myPlaces: LiveData<List<String>>
            get() = _myPlaces

    init{
        Log.i("MyPlacesViewModel", "Init called")
        _myPlaces.value = listOf("Nieuwpoort", "Blankenberghe", "Oostende")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MyPlacesViewModel","OnCleared called")
    }

    fun addPlace(){
        _myPlaces.value = myPlaces.value?.plus("Wenduuune")
    }
}