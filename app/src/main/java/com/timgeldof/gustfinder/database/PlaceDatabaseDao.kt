package com.timgeldof.gustfinder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PlaceDatabaseDao {

    @Query("SELECT * from places_table WHERE placeId = :key")
    fun get(key: Long): Place?
    @Insert
    fun insert(place: Place)
    @Query("SELECT * FROM places_table ORDER BY city DESC")
    fun getAllPlaces(): LiveData<List<Place>>
    @Query("DELETE FROM places_table WHERE placeId = :key")
    fun removePlace(key: Long)
    @Query("DELETE FROM places_table")
    fun clear()


}