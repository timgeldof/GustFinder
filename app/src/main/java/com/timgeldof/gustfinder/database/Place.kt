package com.timgeldof.gustfinder.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "places_table")
data class Place(
    @ColumnInfo(name = "area")
    var area: String,
    @ColumnInfo(name = "country")
    var country: String,
    @ColumnInfo(name = "region")
    var region: String,
    @ColumnInfo(name = "longitude")
    var longitude: String,
    @ColumnInfo(name = "latitude")
    var latitude: String
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var placeId: Long = 0L

    override fun equals(other: Any?): Boolean {
        val otherPlace = other as Place
        return (this.latitude == otherPlace.latitude) && (this.longitude == otherPlace.longitude)
    }
}