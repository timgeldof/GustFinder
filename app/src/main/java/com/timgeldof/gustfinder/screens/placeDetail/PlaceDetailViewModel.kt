package com.timgeldof.gustfinder.screens.placeDetail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.timgeldof.gustfinder.database.GustRepository
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.realm.RealmWeather
import com.timgeldof.gustfinder.screens.addPlace.ApiStatus
import com.timgeldof.gustfinder.screens.addPlace.ApiStatus.DONE
import com.timgeldof.gustfinder.screens.addPlace.ApiStatus.LOADING
import io.realm.RealmResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
/**
 * A [ViewModel] subclass
 *
 * @param place the place of which the details need to be shown
 */
class PlaceDetailViewModel(val place: Place, repository: GustRepository) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _status = MutableLiveData<ApiStatus>()

    val status: LiveData<ApiStatus>
        get() = _status

    private val _dbWeather: LiveData<RealmResults<RealmWeather>> = repository.getWeather(place)

    val dbWeather: LiveData<RealmResults<RealmWeather>>
    get() = _dbWeather

    init {
        _status.value = DONE
        uiScope.launch {
            _status.value = LOADING
            try {
                repository.refreshWeather(place)
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
            }
            _status.value = DONE
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
                            "09:00\n${dbWeather.value!![0]!!.hourly[3]!!.getSurfStatistics()}\n" +
                            "12:00\n${dbWeather.value!![0]!!.hourly[4]!!.getSurfStatistics()}\n" +
                            "15:00\n${dbWeather.value!![0]!!.hourly[5]!!.getSurfStatistics()}\n" +
                            "18:00\n${dbWeather.value!![0]!!.hourly[6]!!.getSurfStatistics()}\n")
                type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        return shareIntent
    }
}