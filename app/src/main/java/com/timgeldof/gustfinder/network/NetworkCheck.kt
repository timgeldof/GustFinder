package com.timgeldof.gustfinder.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log


/**
 * Code directly copied from android developer documentation
 * Deprecated method alert, but only for over API 29 which is above the current target of 19
 *
 * @return isConnected: boolean representing whether the internet is active on the device
 * */

fun networkAvailable(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
    val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
    return isConnected
}