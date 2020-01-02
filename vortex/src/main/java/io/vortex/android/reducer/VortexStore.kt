package io.vortex.android.reducer

import androidx.lifecycle.MutableLiveData
import io.vortex.android.VortexRxStore
import io.vortex.android.state.VortexState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:37 AM
 */

class VortexStore<State : VortexState> : VortexRxStore<State , MutableLiveData<State>> {

    private var viewListener: WeakReference<VortexRxStore.VortexStateListener<State>>? = null
    private val stateObserver: MutableLiveData<State> by lazy {
        MutableLiveData<State>()
    }

    override suspend fun acceptInitialState(initState: State) {
        withContext(Dispatchers.IO) {
            synchronized(stateObserver) {
                stateObserver.postValue(initState)
            }
        }
    }

    override suspend fun getCurrentState(): State? {
       return this.stateObserver.value?.let {
           it
       }
    }

    override suspend fun getStateObserver(): MutableLiveData<State> {
        return this.stateObserver
    }

    override suspend fun destroyStore() {
        withContext(Dispatchers.Main) {
            stateObserver.removeObserver {}
        }

        withContext(Dispatchers.IO) {
            viewListener?.clear()
            viewListener = null
        }
    }

    override suspend fun attachStateListener(listener: VortexRxStore.VortexStateListener<State>) {
        withContext(Dispatchers.IO) {
            viewListener = WeakReference(listener)
        }
    }

}
