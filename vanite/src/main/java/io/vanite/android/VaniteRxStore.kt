package io.vanite.android

import io.vanite.android.state.VaniteState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:54 AM
 */

interface VaniteRxStore<State : VaniteState , O> {

    suspend fun getCurrentState(): State?

    suspend fun acceptInitialState(initState: State)

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun destroyStore()

    suspend fun getStateObserver(): O

    suspend fun attachStateListener(listener: VaniteStateListener<State>)

    interface VaniteStateListener<State : VaniteState> {
        suspend fun onStateChanged(newState: State)

        suspend fun onEffectChanged(newEffect: Any)
    }

}
