package io.vortex.android.base

import androidx.lifecycle.MutableLiveData
import io.vortex.android.VortexIndirectViewModelImpl
import io.vortex.android.VortexViewModelType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * VortexViewModel Class (One of Supported ViewModels)
 * Used to ViewModels That only Needs to Manage State Without Actions
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
abstract class VortexIndirectViewModel<State> : VortexPureViewModel(), VortexIndirectViewModelImpl<State>,
    VortexViewModelType {

    private val state: MutableLiveData<State> by lazy {
        MutableLiveData<State>()
    }

    /**
     * Override The Current State With Your New State By Using This Method
     * To Accept New State
     */
    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {
            state.postValue(newState)
        }
    }

    /**
     * Get Current State To Subscribe it With Current ViewLifecycleOwner
     */
    override fun getStateHandler(): MutableLiveData<State> {
        return state
    }

    /**
     * Get Current Value of Current Saved State in this ViewModel
     */
    override fun getCurrentState(): State? {
        return getStateHandler().value
    }

}
