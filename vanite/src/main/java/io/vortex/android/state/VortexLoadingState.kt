package io.vortex.android.state

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 12:01 PM
 */

class VortexLoadingState(private val loadingState: Boolean) : VortexState {
    fun getLoadingState(): Boolean = loadingState
}
