package io.vanite.android

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.vanite.android.keys.VaniteViewModelState
import io.vanite.android.rx.VaniteRxRepository

interface VaniteModelStateImpl {

    suspend fun acceptNewState(newState: VaniteViewModelState)

    fun getStateHandler(): MutableLiveData<VaniteViewModelState>

    fun getRepositoryHandler(): VaniteRxRepository

    fun getCurrentViewModelState(): VaniteViewModelState?

    suspend fun addRxRequest(request: Disposable)

    suspend fun execute(newAction: Any)

}