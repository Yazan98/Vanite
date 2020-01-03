package io.vortex.android

/**
 * Created By : Yazan Tarifi
 * Date : 1/3/2020
 * Time : 3:00 AM
 */

interface VortexNetworkListener {

    suspend fun onNetworkConnected()

    suspend fun onNetworkDisconnected()

}
