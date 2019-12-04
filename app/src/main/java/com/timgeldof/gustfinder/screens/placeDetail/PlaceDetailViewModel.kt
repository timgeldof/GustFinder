package com.timgeldof.gustfinder.screens.placeDetail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.network.models.marineWeatherApi.Weather
import com.timgeldof.gustfinder.network.service.GustFinderApi
import com.timgeldof.gustfinder.screens.addPlace.ApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
/**
 * A [ViewModel] subclass
 *
 * @param place the place of which the details need to be shown
 */
class PlaceDetailViewModel(val place: Place) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _weather = MutableLiveData<List<Weather>>()

    val weather: LiveData<List<Weather>>
        get() = _weather

    private val _status = MutableLiveData<ApiStatus>()

    val status: LiveData<ApiStatus>
        get() = _status

    init {
        getForecasts()
        _status.value = ApiStatus.ERROR
    }
    /**
     * Sets the weather [LiveData] value to the response of the api
     */
    private fun getForecasts() {
        val latAndLon = place.latitude + "," + place.longitude
        uiScope.launch {
            try {
                _status.value = ApiStatus.LOADING
                _weather.value = GustFinderApi.retrofitService.getForecastAsync(latAndLon).await().data.weather
                _status.value = ApiStatus.DONE
            } catch (t: Throwable) {
                _status.value = ApiStatus.ERROR
            }
        }
    }
    /**
     * Creates a share intent to share the forecasts of the current day
     * @return the share intent
     */
    fun shareWeatherIntent(): Intent {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,
                "The conditions for ${place.area} seem interesting for today!\n" +
                        "Perhaps we can meet up sometimes for a surf session?\n\n" +
                        "09:00\n${_weather.value!![0].hourly[3].getSurfStatistics()}\n" +
                        "12:00\n${_weather.value!![0].hourly[4].getSurfStatistics()}\n" +
                        "15:00\n${_weather.value!![0].hourly[5].getSurfStatistics()}\n" +
                        "18:00\n${_weather.value!![0].hourly[6].getSurfStatistics()}\n")
                    type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        return shareIntent
    }
}