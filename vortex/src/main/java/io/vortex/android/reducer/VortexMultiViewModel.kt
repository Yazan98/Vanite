package io.vortex.android.reducer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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

abstract class VortexMultiViewModel<State: VortexState, Action: VortexAction> : ViewModel(), VortexMultiViewModelImpl<State, Action> {

    private val state: MediatorLiveData<State> by lazy {
        MediatorLiveData<State>()
    }

    private val repository: VortexRxRepository by lazy {
        VortexRxRepository()
    }

    private val loadingState: MutableLiveData<VortexLoadingState> by lazy {
        MutableLiveData<VortexLoadingState>()
    }

    override suspend fun acceptNewState(newState: LiveData<State>) {
        withContext(Dispatchers.IO) {
            state.addSource(newState, Observer {
                state.value = it
            })
        }
    }

    override suspend fun acceptLoadingState(newState: Boolean) {
        withContext(Dispatchers.IO) {
            loadingState.postValue(VortexLoadingState(newState))
        }
    }

    override suspend fun getLoadingState(): MutableLiveData<VortexLoadingState> {
        return withContext(Dispatchers.IO) {
            loadingState
        }
    }

    override suspend fun getState(): LiveData<State> {
        return withContext(Dispatchers.IO) {
            state
        }
    }

    override suspend fun destroyViewModel() {
        withContext(Dispatchers.IO) {
            repository.clearRepository()
        }
    }

    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            repository.addRequest(request)
        }
    }

    override fun onCleared() {
        GlobalScope.launch {
            destroyViewModel()
        }
        super.onCleared()
    }

}
