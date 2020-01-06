package io.vortex.android.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.vortex.android.VortexRxStore
import io.vortex.android.state.VortexState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:23 AM
 */

class VortexStateDelegate<State : VortexState>(private val vortexStore: VortexStore<State>?) :
    VortexStateDelegateImpl<State> {

    private var stateHandler: WeakReference<VortexRxStore.VortexStateListener<State>>? = null

    override suspend fun commitStoreHandler(handler: VortexRxStore.VortexStateListener<State>) {
        withContext(Dispatchers.IO) {
            stateHandler = WeakReference(handler)
        }
    }

    override suspend fun subscribeStateHandler(context: Fragment?) {
        withContext(Dispatchers.Main) {
            context?.let {
                it.apply {
                    vortexStore?.getStateObserver()?.observe(this, stateObserver)
                }
            }
        }
    }

    private val stateObserver: Observer<State> = Observer { t ->
        stateHandler?.let {
            it.get()?.let {
                GlobalScope.launch {
                    it.onStateChanged(t)
                }
            }
        }
    }

    override suspend fun unSubscribeStateHandler() {
        withContext(Dispatchers.Main) {
            vortexStore?.getStateObserver()?.removeObserver(stateObserver)
            stateHandler?.let {
                it.clear()
                stateHandler = null
            }
        }
    }

}
