package com.timgeldof.gustfinder

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class GustApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun getBaseContext(): Context {
        return super.getBaseContext()
    }
}