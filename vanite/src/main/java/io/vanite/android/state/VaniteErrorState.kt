package io.vanite.android.state

import io.vanite.android.errors.VaniteException

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:41 PM
 */

class VaniteErrorState(private val error: VaniteException) : VaniteState {
    fun getError(): VaniteException = error
}
