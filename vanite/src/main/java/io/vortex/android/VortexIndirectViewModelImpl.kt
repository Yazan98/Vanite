package io.vortex.android

import androidx.lifecycle.MutableLiveData

interface VortexIndirectViewModelImpl<State> {

    suspend fun execute(newAction: Any)

    suspend fun acceptNewState(newState: State)

    fun getStateHandler(): MutableLiveData<State>

    fun getCurrentState(): State?

}
