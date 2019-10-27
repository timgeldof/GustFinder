package com.timgeldof.gustfinder.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "places_table")
data class Place(
    @PrimaryKey(autoGenerate = true)
    var placeId: Long = 0L,
    @ColumnInfo(name = "city")
    var city: String,
    @ColumnInfo(name = "country_iso_code")
    var countryCodeISO: String
)