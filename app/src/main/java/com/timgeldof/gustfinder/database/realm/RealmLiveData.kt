package com.timgeldof.gustfinder.database.realm

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmResults


// SOURCE: https://proandroiddev.com/the-realm-of-kotlin-and-live-data-using-mvp-architecture-f04fc41c914e
class RealmLiveData <T : RealmModel>(val realmResults: RealmResults<T>) : LiveData<RealmResults<T>>() {

    private val listener = RealmChangeListener<RealmResults<T>> { results -> value = results }

    override fun onActive() {
        realmResults.addChangeListener(listener)
    }

    override fun onInactive() {
        realmResults.removeChangeListener(listener)
    }
}