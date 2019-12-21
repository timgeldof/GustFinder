package com.timgeldof.gustfinder.database.realm

import io.realm.RealmModel
import io.realm.RealmResults

fun <T: RealmModel> RealmResults<T>.asLiveData() = RealmLiveData<T>(this)



