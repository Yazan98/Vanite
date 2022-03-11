package io.vanite.android

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.vanite.android.rx.VaniteRxRepository
import io.vanite.android.state.VaniteLoadingState
import io.vanite.android.state.VaniteState

interface VaniteSingleStateViewModelImpl<State: VaniteState> {

    suspend fun execute(newAction: Any)

    suspend fun acceptNewState(newState: State)

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun addRxRequest(request: Disposable)

    fun getStateHandler(): MutableLiveData<State>

    fun getLoadingStateHandler(): MutableLiveData<VaniteLoadingState>

    fun getRxRepository(): VaniteRxRepository

}
