package com.timgeldof.gustfinder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * GustDatabase extends the [RoomDatabase] class for usage within the Gustfinder app
 */
@Database(entities = [Place::class], version = 3, exportSchema = false)
abstract class GustDatabase : RoomDatabase() {
    /**
     * This property of class [PlaceDatabaseDao] is publicly available to all classes to support api calls
     */
    abstract val placeDatabaseDao: PlaceDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: GustDatabase? = null
        /**
         * Returns an instance of GustDatabase using the singleton pattern
         * @return the singleton instance of GustDatabase
         */
        fun getInstance(context: Context): GustDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GustDatabase::class.java,
                        "gust_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}