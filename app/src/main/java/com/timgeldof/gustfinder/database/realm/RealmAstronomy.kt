package com.timgeldof.gustfinder.database.realm

import io.realm.RealmObject

open class RealmAstronomy(

    var sunrise: String,
    var sunset: String,
    var moonrise: String,
    var moonset: String,
    var moon_phase: String,
    var moon_illumination: Int
): RealmObject(){
    constructor() : this("","","","","",0)
}