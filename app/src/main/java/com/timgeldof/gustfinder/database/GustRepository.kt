package com.timgeldof.gustfinder.database

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.timgeldof.gustfinder.GustApplication
import com.timgeldof.gustfinder.database.realm.RealmWeather
import com.timgeldof.gustfinder.database.realm.asLiveData
import com.timgeldof.gustfinder.network.networkAvailable
import com.timgeldof.gustfinder.network.service.GustFinderApi
import com.timgeldof.gustfinder.network.service.GustFinderApiService
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GustRepository(database: GustDatabase){


    fun getWeather(place: Place): LiveData<RealmResults<RealmWeather>> {
        val realm = Realm.getDefaultInstance()
        var results: RealmResults<RealmWeather> =  realm.where(RealmWeather::class.java)
            .beginsWith("latLonDateKey",place.latitude+"_" + place.longitude)
            .sort("created", Sort.DESCENDING)
            .findAllAsync()
        return results.asLiveData()
    }

    suspend fun refreshWeather(place: Place){
        if(networkAvailable(GustApplication.applicationContext())){
        val latAndLon = place.latitude + "," + place.longitude

        withContext(Dispatchers.Main){
            val realm = Realm.getDefaultInstance()
            var realmWeather =  RealmList<RealmWeather>()

            val weatherList = GustFinderApi.retrofitService.getForecastAsync(latAndLon).await().data.weather
            realmWeather = RealmList<RealmWeather>()
            for (weather in weatherList) {
                realmWeather.add(weather.weatherAsRealmModel(place))
            }
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(realmWeather)
            realm.commitTransaction()
        }
        }
    }
}
