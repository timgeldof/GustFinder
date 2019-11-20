package com.timgeldof.gustfinder.screens.add_place

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import com.timgeldof.gustfinder.network.models.ApiSearchResponse
import com.timgeldof.gustfinder.network.models.Result
import com.timgeldof.gustfinder.network.service.GustFinderLocationApi
import com.timgeldof.gustfinder.network.service.GustFinderLocationApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

    fun getSearchResults(query : String){
        if(query.length>3){
            uiScope.launch {
                try{
                    _status.value = ApiStatus.LOADING
                    Log.i("API", query)
                    _response.value = GustFinderLocationApi.retrofitService.getLocationSearchResultsAsync(query).await()
                    _status.value = ApiStatus.DONE
                } catch (t: Throwable){
                    _status.value = ApiStatus.ERROR
                    Log.i("API", t.message)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}