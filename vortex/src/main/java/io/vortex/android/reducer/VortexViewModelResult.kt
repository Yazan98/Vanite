package io.vortex.android.reducer

import io.vortex.android.VortexAction
import io.vortex.android.rx.VortexRequestProvider
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:15 PM
 */

abstract class VortexViewModelResult<State : VortexState, Action : VortexAction , Result> : VortexViewModel<State, Action>() {
    protected fun getRequestProvider(): VortexRequestProvider<Result> = VortexRequestProvider<Result>()
}
