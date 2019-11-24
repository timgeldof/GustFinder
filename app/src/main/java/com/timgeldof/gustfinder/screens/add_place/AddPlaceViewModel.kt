package com.timgeldof.gustfinder.screens.add_place

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import com.timgeldof.gustfinder.network.models.search_api.ApiSearchResponse
import com.timgeldof.gustfinder.network.service.GustFinderApi
import kotlinx.coroutines.*

enum class ApiStatus{LOADING, ERROR,DONE}

class AddPlaceViewModel(val database: PlaceDatabaseDao, application: Application): AndroidViewModel(application){

    private var viewModelJob = Job()
    private val uiScope  = CoroutineScope(Dispatchers.Main + viewModelJob)
    // error handling
    private val _status = MutableLiveData<ApiStatus>()

    val status: LiveData<ApiStatus>
        get() = _status
    // api request
    private val _response = MutableLiveData<ApiSearchResponse>()

    val response: LiveData<ApiSearchResponse>
        get() = _response

    init {
        _status.value = ApiStatus.ERROR
    }

    fun getSearchResults(query : String){
        if(query.length>3){
            uiScope.launch {
                try{
                    _status.value = ApiStatus.LOADING
                    Log.i("API", query)
                    _response.value = GustFinderApi.retrofitService.getLocationSearchResultsAsync(query).await()
                    _status.value = ApiStatus.DONE
                } catch (t: Throwable){
                    _status.value = ApiStatus.ERROR
                }
            }
        }
    }
    suspend fun insertPlaceIntoDatabase(place: Place){
        withContext(Dispatchers.IO) {
            database.insert(place)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}