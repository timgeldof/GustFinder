package com.timgeldof.gustfinder

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
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
}