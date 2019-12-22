package com.timgeldof.gustfinder.unit

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.database.PlaceDatabaseDao
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class PlaceUnitTests {


    private lateinit var database: GustDatabase
    private lateinit var placeDao: PlaceDatabaseDao


    @Before
    fun setUpDataBase(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, GustDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        placeDao = database.placeDatabaseDao

    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertPlace() {
        val placeInMemory = Place("Kortrijk","Belgie","West-Vlaanderen","50.3","30.4")
        placeDao.insert(placeInMemory)
        val PlaceFromDB = placeDao.get("Kortrijk")
        Assert.assertEquals(placeInMemory.area, PlaceFromDB.area)
        placeDao.clear()
    }


    @Test
    fun deletePlace() {
        val placeInMemory = Place("Izegem","Belgie","West-Vlaanderen","50.3","23.4")
        placeDao.insert(placeInMemory)
        val PlaceFromDB = placeDao.get("Izegem")
        Assert.assertEquals(placeInMemory.area, PlaceFromDB.area)
        placeDao.clear()
        Assert.assertNull(placeDao.get("Izegem"))
    }





}