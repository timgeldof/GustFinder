package com.timgeldof.gustfinder

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import io.realm.Realm

/**
 * A simple [Application] subclass.
 */
class GustApplication : Application() {
    /**
     * Overrides the attachBaseContext from the [Application] class and installs MultiDex into the [Context] in order to support over 64K methods
     * @param base parameter of class [Context] which contains information about the application environment
     */
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    init {
        instance = this
    }
    override fun onCreate() {
        super.onCreate()
        val context: Context = applicationContext()
        Realm.init(this)
    }

    companion object {
        private var instance: GustApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}