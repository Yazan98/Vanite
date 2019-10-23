package io.vortex.android

import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:54 AM
 */

interface VortexRxStore<State : VortexState , O> {

    suspend fun getCurrentState(): State?

    suspend fun acceptInitialState(initState: State)

    suspend fun destroyStore()

    suspend fun getStateObserver(): O

    suspend fun attachStateListener(listener: VortexStateListener<State>)

    interface VortexStateListener<State : VortexState> {
        suspend fun onStateChanged(newState: State)
    }

}
