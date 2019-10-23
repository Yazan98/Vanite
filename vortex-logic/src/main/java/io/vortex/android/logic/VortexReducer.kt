package io.vortex.android.logic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vortex.android.VortexAction
import io.vortex.android.VortexRxReducer
import io.vortex.android.VortexRxStore
import io.vortex.android.rx.VortexRxRepository
import io.vortex.android.state.VortexState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:32 AM
 */

abstract class VortexReducer<State : VortexState, Action : VortexAction> :
    ViewModel(),
    VortexRxReducer<State, Action, VortexStore<State> , MutableLiveData<State>> {

    private val reducerStore: MutableLiveData<VortexStore<State>> by lazy {
        MutableLiveData<VortexStore<State>>()
    }

    private val repo: VortexRxRepository by lazy {
        VortexRxRepository()
    }

    init {
        GlobalScope.launch {
            acceptInitialState(getInitialState())
            reducerStore.postValue(VortexStore())
        }
    }

    override suspend fun acceptInitialState(initialState: State) {
        withContext(Dispatchers.IO) {
            getVortexStore().acceptInitialState(initialState)
        }
    }

    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {
            getVortexStore().getStateObserver().postValue(newState)
        }
    }

    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            repo.addRequest(request)
        }
    }

    override suspend fun destroyReducer() {
        withContext(Dispatchers.IO) {
            repo.clearRepository()
        }
    }

    override suspend fun attachStateSubscriber(storeSubscriber: VortexRxStore.VortexStateListener<State>) {
        withContext(Dispatchers.IO) {
            getVortexStore().attachStateListener(storeSubscriber)
        }
    }

    override suspend fun getVortexStore(): VortexRxStore<State, MutableLiveData<State>> {
        return withContext(Dispatchers.IO) {
            reducerStore.value!!
        }
    }

}
