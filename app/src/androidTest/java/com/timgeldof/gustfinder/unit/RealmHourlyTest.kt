package com.timgeldof.gustfinder.unit

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.timgeldof.gustfinder.database.realm.RealmHourly
import com.timgeldof.gustfinder.database.realm.RealmWeatherIconUrl
import io.realm.RealmList
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RealmHourlyTest {

    private var hourly: RealmHourly? = null

    @Before
    fun setUp() {
        hourly =
            RealmHourly(9, 20, 20, "NNW", RealmList<RealmWeatherIconUrl>(), 15, 1.3, "NNW", 2.3, 15)
    }

    @After
    fun tearDown() {
        hourly = null
    }

    @Test
    fun checkGustSpeedFormat() {
        Assert.assertEquals(hourly!!.getWindGustFormatted(), "${hourly!!.windGustKmph} km/h")
    }
    @Test
    fun checkEmptyGustFormatResult() {
        hourly!!.windGustKmph = null
        Assert.assertEquals(hourly!!.getWindGustFormatted(), "-")
        hourly!!.windGustKmph = 15
    }
    @Test
    fun checkTemperatureFormat() {
        Assert.assertEquals(hourly!!.getTempFormatted(), "${hourly!!.tempC} °C")
    }
    @Test
    fun checkWaterTempFormat() {
        Assert.assertEquals(hourly!!.getWaterTempFormatted(), "${hourly!!.waterTemp_C} °C")
    }
    @Test
    fun checkSwellHeightFormat() {
        Assert.assertEquals(hourly!!.getSwellHeightFormatted(), "${hourly!!.swellHeight_m} m")
    }
    @Test
    fun checkSwellDirFormat() {
        Assert.assertEquals(hourly!!.getSwellDir16point(), "NNW")
    }
    @Test
    fun checkEmptySwellDirFormatResult() {
        hourly!!.swellDir16Point = null
        Assert.assertEquals(hourly!!.getSwellDir16point(), "-")
        hourly!!.swellDir16Point = "NNW"
    }
}