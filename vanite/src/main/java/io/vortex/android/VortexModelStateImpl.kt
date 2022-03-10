package io.vortex.android

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.vortex.android.keys.VortexViewModelState
import io.vortex.android.rx.VortexRxRepository

interface VortexModelStateImpl {

    suspend fun acceptNewState(newState: VortexViewModelState)

    fun getStateHandler(): MutableLiveData<VortexViewModelState>

    fun getRepositoryHandler(): VortexRxRepository

    fun getCurrentViewModelState(): VortexViewModelState?

    suspend fun addRxRequest(request: Disposable)

    suspend fun execute(newAction: Any)

}