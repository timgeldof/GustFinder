package com.timgeldof.gustfinder.database.realm

import io.realm.RealmObject

/**
 * Contains a url that refers to an image resource stored on the WorldWeatherAPI servers
 */
open class RealmWeatherIconUrl(

    var value: String
) : RealmObject() {
    constructor() : this("")
}