package io.vanite.android.utils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:54 AM
 */

@Deprecated("Network Info Deprecated")
object NetworkUtils {

    private var connectivityManager: ConnectivityManager? = null
    private var nwInfo: NetworkInfo? = null
    private var cm: ConnectivityManager? = null

    @SuppressLint("MissingPermission")
    fun isNetworkConnection(context: Context): Boolean {
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val nwInfo = connectivityManager!!.activeNetworkInfo
        return nwInfo != null && nwInfo.isConnectedOrConnecting
    }

    private fun getNetworkInfo(context: Context): NetworkInfo? {
        cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm?.activeNetworkInfo
    }

}