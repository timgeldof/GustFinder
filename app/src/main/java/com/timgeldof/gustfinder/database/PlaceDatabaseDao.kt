package com.timgeldof.gustfinder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
/**
 * PlaceDatabaseDao is an interface class which contains the methods that will be used by the GustDatabase
 */
@Dao
interface PlaceDatabaseDao {
    /**
     * @param key The primary key for the place table in the database
     * @return returns [LiveData] that wraps a Place object
     */
    @Query("SELECT * from places_table WHERE placeId = :key")
    fun get(key: Long): LiveData<Place>
    /**
     * @param place Place that has to be inserted into the places_table in the database
     * @return returns [LiveData] that wraps a Place object
     */
    @Insert
    fun insert(place: Place)
    /**
     * @return returns [LiveData] that wraps a a list of [Place] objects
     */
    @Query("SELECT * FROM places_table ORDER BY area ASC")
    fun getAllPlaces(): LiveData<List<Place>>
    /**
     * deletes the row with the given key in the database
     * @param key The primary key for the places_table in the database
     */
    @Query("DELETE FROM places_table WHERE placeId = :key")
    fun removePlace(key: Long)
    /**
     * Deletes all of the place rows in the places_table
     */
    @Query("DELETE FROM places_table")
    fun clear()
}