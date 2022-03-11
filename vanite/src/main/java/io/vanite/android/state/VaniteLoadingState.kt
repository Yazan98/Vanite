package io.vanite.android.state

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 12:01 PM
 */

class VaniteLoadingState(private val loadingState: Boolean) : VaniteState {
    fun getLoadingState(): Boolean = loadingState
}
