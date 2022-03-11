package io.vanite.android.base

import androidx.lifecycle.*
import io.reactivex.disposables.Disposable
import io.vanite.android.VaniteAction
import io.vanite.android.VaniteMultiViewModelImpl
import io.vanite.android.VaniteViewModelType
import io.vanite.android.rx.VaniteRxRepository
import io.vanite.android.state.VaniteLoadingState
import io.vanite.android.state.VaniteState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * This ViewModel Used When You Want to add Multiple MutableLiveData Inside MediatorLiveData
 * The Current State Will be MediatorLiveData To Hold More Than One State Per Screen
 *
 * Note: Full Implementation of An Vanite ViewModel With State, Action, RxJava is Available at @see VaniteViewModel
 */
abstract class VaniteMultiViewModel<State: VaniteState, Action: VaniteAction> : ViewModel(), VaniteMultiViewModelImpl<State, Action>,
    VaniteViewModelType {

    private val state: MediatorLiveData<State> by lazy {
        MediatorLiveData<State>()
    }

    private val repository: VaniteRxRepository by lazy {
        VaniteRxRepository()
    }

    private val loadingState: MutableLiveData<VaniteLoadingState> by lazy {
        MutableLiveData<VaniteLoadingState>()
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
            loadingState.postValue(VaniteLoadingState(newState))
        }
    }

    override suspend fun getLoadingState(): MutableLiveData<VaniteLoadingState> {
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
