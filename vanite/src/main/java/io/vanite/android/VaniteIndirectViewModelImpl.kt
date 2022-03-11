package io.vanite.android

import androidx.lifecycle.MutableLiveData

interface VaniteIndirectViewModelImpl<State> {

    suspend fun execute(newAction: Any)

    suspend fun acceptNewState(newState: State)

    fun getStateHandler(): MutableLiveData<State>

    fun getCurrentState(): State?

}
