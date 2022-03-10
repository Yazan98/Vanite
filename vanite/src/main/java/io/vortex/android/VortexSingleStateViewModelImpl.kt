package io.vortex.android

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.vortex.android.rx.VortexRxRepository
import io.vortex.android.state.VortexLoadingState
import io.vortex.android.state.VortexState

interface VortexSingleStateViewModelImpl<State: VortexState> {

    suspend fun execute(newAction: Any)

    suspend fun acceptNewState(newState: State)

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun addRxRequest(request: Disposable)

    fun getStateHandler(): MutableLiveData<State>

    fun getLoadingStateHandler(): MutableLiveData<VortexLoadingState>

    fun getRxRepository(): VortexRxRepository

}
