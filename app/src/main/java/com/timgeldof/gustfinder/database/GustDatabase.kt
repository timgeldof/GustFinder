package com.timgeldof.gustfinder.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities=[Place::class], version = 3)
abstract class GustDatabase : RoomDatabase() {
    abstract val placeDatabaseDao: PlaceDatabaseDao

    companion object{
        @Volatile //direct beschikbaar voor andere threads
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
                Log.i("Database", instance.toString())
            }
        }
    }
}