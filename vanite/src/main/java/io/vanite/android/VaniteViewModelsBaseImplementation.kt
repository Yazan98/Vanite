package io.vanite.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import io.vanite.android.state.VaniteLoadingState
import io.vanite.android.state.VaniteState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:47 AM
 */

interface VaniteRxReducer<State : VaniteState, Action : VaniteAction> {

    suspend fun execute(newAction: Action)

    suspend fun acceptInitialState(initialState: State)

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun acceptEffectHandlerState(newEffect: Any)

    suspend fun addRxRequest(request: Disposable)

    suspend fun getInitialState(): State

    suspend fun acceptNewState(newState: State)

    suspend fun destroyViewModel()

}

interface VaniteMultiViewModelImpl<State : VaniteState, Action : VaniteAction> {

    suspend fun execute(newAction: Action)

    suspend fun acceptNewState(newState: LiveData<State>)

    suspend fun addRxRequest(request: Disposable)

    suspend fun destroyViewModel()

    suspend fun acceptLoadingState(newState: Boolean)

    suspend fun getState(): LiveData<State>

    suspend fun getLoadingState(): MutableLiveData<VaniteLoadingState>

}
