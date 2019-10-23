package io.vortex.android.logic

import io.vortex.android.VortexAction
import io.vortex.android.rx.VortexRequestProvider
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:15 PM
 */

abstract class VortexResultReducer<State : VortexState, Action : VortexAction , Result> : VortexReducer<State , Action>() {
    protected fun getRequestProvider(): VortexRequestProvider<Result> = VortexRequestProvider<Result>()
}
