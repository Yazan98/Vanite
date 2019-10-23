package io.vortex.android.data.executer

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 3:04 PM
 */

interface VortexExecuter<L: VortexRequestListener> {

    suspend fun attachListener(listener: L?)

}