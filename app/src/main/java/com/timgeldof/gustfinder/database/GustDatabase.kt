package com.timgeldof.gustfinder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities=[Place::class], version = 1,exportSchema = false)
abstract class GustDatabase : RoomDatabase() {
    abstract val placeDatabaseDao: PlaceDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: GustDatabase?= null

        fun getInstance(context:Context): GustDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
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