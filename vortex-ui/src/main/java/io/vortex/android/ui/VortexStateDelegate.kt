package io.vortex.android.ui

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import io.vortex.android.VortexRxStore
import io.vortex.android.logic.VortexStore
import io.vortex.android.state.VortexLoadingState
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

    override suspend fun subscribeStateHandler(context: FragmentActivity?) {
        withContext(Dispatchers.IO) {
            context?.let {
                it.apply {
                    vortexStore?.getStateObserver()?.observe(this, stateObserver)
                }
            }
        }
    }

    override suspend fun subscribeLoadingHandler(context: FragmentActivity?) {
        withContext(Dispatchers.IO) {
            context?.let {
                vortexStore?.loadingState?.observe(it, loadingObserver)
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

    private val loadingObserver: Observer<Boolean> = Observer { loadingState ->
        stateHandler?.let {
            it.get()?.let {
                GlobalScope.launch {
                    when (loadingState) {
                        true -> it.onStateChanged(VortexLoadingState(true) as State)
                        false -> it.onStateChanged(VortexLoadingState(false) as State)
                    }
                }
            }
        }
    }

    override suspend fun unSubscribeStateHandler() {
        withContext(Dispatchers.Main) {
            vortexStore?.getStateObserver()?.removeObserver(stateObserver)
            vortexStore?.loadingState?.removeObserver(loadingObserver)
            stateHandler?.let {
                it.clear()
                stateHandler = null
            }
        }
    }

}
