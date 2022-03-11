package io.vanite.android.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vanite.android.VaniteSingleStateViewModelImpl
import io.vanite.android.VaniteViewModelType
import io.vanite.android.rx.VaniteRxRepository
import io.vanite.android.state.VaniteLoadingState
import io.vanite.android.state.VaniteState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * This ViewModel Used To Create ViewModel With Only State, Without Actions To ViewModel
 * Not Recommended To Use But It's Option Available in Vanite
 *
 * Note: Full Implementation of An Vanite ViewModel With State, Action, RxJava is Available at @see VaniteViewModel
 */
abstract class VaniteSingleStateViewModel<State : VaniteState> : ViewModel(), VaniteSingleStateViewModelImpl<State>,
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

    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {
            getStateHandler().postValue(newState)
        }
    }

    override suspend fun acceptLoadingState(newState: Boolean) {
        withContext(Dispatchers.IO) {
            getLoadingStateHandler().postValue(VaniteLoadingState(newState))
        }
    }

    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            getRxRepository().addRequest(request)
        }
    }

    override fun getStateHandler(): MutableLiveData<State> {
       return state
    }

    override fun getLoadingStateHandler(): MutableLiveData<VaniteLoadingState> {
        return loadingState
    }

    override fun getRxRepository(): VaniteRxRepository {
        return repository
    }

    override fun onCleared() {
        getRxRepository().clearRepository()
        super.onCleared()
    }

}
