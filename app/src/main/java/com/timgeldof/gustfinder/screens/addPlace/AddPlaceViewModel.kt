package com.timgeldof.gustfinder.screens.addPlace

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.GustRepository
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import com.timgeldof.gustfinder.network.models.searchApi.ApiSearchResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

enum class ApiStatus { LOADING, ERROR, DONE }
/**
 * Subclass of the [AndroidViewModel]
 *
 * @param database [PlaceDatabaseDao] to be used in this class to insert the new Place
 * @param application
 * @sample com.mycompany.SomethingTest.simple
 */
class AddPlaceViewModel(val repository: GustRepository) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
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
    /**
     * Sets the value of the _response [LiveData] to the api response by using debounce implemented with coroutines
     *
     * @param query the search query parameter for the Search API
     */
    fun getSearchResults(query: String) {
        if (query.length>3) {
            uiScope.launch {
                try {
                    _status.value = ApiStatus.LOADING
                    Log.i("API", query)
                    _response.value = GustRepository.getSearchResults(query).await()
                    _status.value = ApiStatus.DONE
                } catch (t: Throwable) {
                    _status.value = ApiStatus.ERROR
                }
            }
        }
    }
    /**
     * Inserts place into the places_table in a coroutine within the IO context
     *
     * @param place the place that needs to be inserted into the database
     */
    suspend fun insertPlaceIntoDatabase(place: Place) {
        withContext(Dispatchers.IO) {
            repository.insertPlace(place)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}