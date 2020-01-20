package io.vortex.android.reducer.multi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vortex.android.VortexAction
import io.vortex.android.VortexMultiViewModelImpl
import io.vortex.android.rx.VortexRxRepository
import io.vortex.android.state.VortexLoadingState
import io.vortex.android.state.VortexState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class VortexMultiViewModel<State : VortexState, Action : VortexAction> : ViewModel(), VortexMultiViewModelImpl<State, Action> {

    private val state: MediatorLiveData<State> by lazy {
        MediatorLiveData<State>()
    }

    private val viewManager: VortexViewExecutor<State, Action> by lazy {
        VortexViewExecutor<State, Action>()
    }

    private val loading: MutableLiveData<VortexLoadingState> by lazy {
        MutableLiveData<VortexLoadingState>()
    }

    private val rxRepository: VortexRxRepository by lazy {
        VortexRxRepository()
    }

    override suspend fun acceptLoadingState(newState: Boolean) {
        withContext(Dispatchers.IO) {
            loading.postValue(VortexLoadingState(newState))
        }
    }

    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {

        }
    }

    override suspend fun getLoadingState(): MutableLiveData<VortexLoadingState> {
        return withContext(Dispatchers.IO) {
            loading
        }
    }

    override suspend fun getState(): LiveData<State> {
        return withContext(Dispatchers.IO) {
            state
        }
    }

    override suspend fun createSource(newSource: State, tag: String) {
        withContext(Dispatchers.IO) {
            viewManager.createState(newSource, tag)
        }
    }

    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            rxRepository.addRequest(request)
        }
    }

    override suspend fun destroyViewModel() {
        withContext(Dispatchers.IO) {
            rxRepository.clearRepository()
            viewManager.destroyAllStates()
        }
    }

    override suspend fun getStateManager(): VortexViewExecutor<State, Action> {
        return withContext(Dispatchers.IO) {
            viewManager
        }
    }

    override suspend fun destroyStateByTag(tag: String) {
        withContext(Dispatchers.IO) {
            viewManager.destroyStateByTag(tag)
        }
    }

    override fun onCleared() {
        GlobalScope.launch {
            destroyViewModel()
        }
        super.onCleared()
    }

}