package io.vortex.android.base

import androidx.lifecycle.*
import io.reactivex.disposables.Disposable
import io.vortex.android.VortexAction
import io.vortex.android.VortexMultiViewModelImpl
import io.vortex.android.VortexViewModelType
import io.vortex.android.rx.VortexRxRepository
import io.vortex.android.state.VortexLoadingState
import io.vortex.android.state.VortexState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

abstract class VortexMultiViewModel<State: VortexState, Action: VortexAction> : ViewModel(), VortexMultiViewModelImpl<State, Action>,
    VortexViewModelType {

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
        try {
            viewModelScope.launch(Dispatchers.IO) {
                destroyViewModel()
            }
        } catch (ex: Exception) {
            // Ignore Exception if Throws
        }
        super.onCleared()
    }

}
