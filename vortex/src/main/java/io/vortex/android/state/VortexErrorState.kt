package io.vortex.android.state

import io.vortex.android.errors.VortexException

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:41 PM
 */

class VortexErrorState(private val error: VortexException) : VortexState {
    fun getError(): VortexException = error
}
