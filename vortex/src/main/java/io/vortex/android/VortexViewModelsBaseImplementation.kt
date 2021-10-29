package io.vortex.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.vortex.android.state.VortexLoadingState
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:47 AM
 */

interface VortexRxReducer<State : VortexState, Action : VortexAction> {

    suspend fun execute(newAction: Action)

    suspend fun acceptInitialState(initialState: State)

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun addRxRequest(request: Disposable)

    suspend fun getInitialState(): State

    suspend fun acceptNewState(newState: State)

    suspend fun destroyViewModel()

}

interface VortexMultiViewModelImpl<State : VortexState, Action : VortexAction> {

    suspend fun execute(newAction: Action)

    suspend fun acceptNewState(newState: LiveData<State>)

    suspend fun addRxRequest(request: Disposable)

    suspend fun destroyViewModel()

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun getState(): LiveData<State>

    suspend fun getLoadingState(): MutableLiveData<VortexLoadingState>

}
