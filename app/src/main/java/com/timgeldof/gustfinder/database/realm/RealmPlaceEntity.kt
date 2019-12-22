package com.timgeldof.gustfinder.database.realm

import io.realm.RealmObject

open class RealmPlaceEntity(
    var longitude: String,
    var latitude: String
) : RealmObject() {
    constructor() : this("", "")
}