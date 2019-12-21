package com.timgeldof.gustfinder.database.realm

import io.realm.RealmObject


/**
 * Contains an English simple, understandable description of the weather
 */
open class RealmWeatherDesc(
    var value: String
): RealmObject(){
    constructor(): this("")

}