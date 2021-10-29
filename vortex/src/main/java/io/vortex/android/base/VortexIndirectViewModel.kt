package io.vortex.android.base

import androidx.lifecycle.MutableLiveData
import io.vortex.android.VortexIndirectViewModelImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class VortexIndirectViewModel<State> : VortexPureViewModel(), VortexIndirectViewModelImpl<State> {

    private val state: MutableLiveData<State> by lazy {
        MutableLiveData<State>()
    }

    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {
            state.postValue(newState)
        }
    }

    override fun getStateHandler(): MutableLiveData<State> {
        return state
    }

    override fun getCurrentState(): State? {
        return getStateHandler().value
    }

}
