package io.vortex.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import io.vortex.android.VortexAction
import io.vortex.android.VortexRxStore
import io.vortex.android.logic.VortexReducer
import io.vortex.android.logic.VortexStore
import io.vortex.android.state.VortexState
import io.vortex.android.ui.VortexStateDelegate
import io.vortex.android.ui.VortexViewImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:51 AM
 */

abstract class VortexFragment<State : VortexState, Action : VortexAction, Reducer : VortexReducer<State, Action>> :
    VortexBaseFragment(), VortexRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    private var stateDelegation: VortexStateDelegate<State>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            stateDelegation = VortexStateDelegate(getController().getVortexStore() as VortexStore<State>)
            stateDelegation.apply {
                this?.commitStoreHandler(this@VortexFragment)
                activity?.let {
                    this?.subscribeStateHandler(it)
                    this?.subscribeLoadingHandler(it)
                }
            }

            getController().getVortexStore().apply {
                this?.attachStateListener(this@VortexFragment)
            }
        }
    }

    override fun onDestroy() {
        GlobalScope.launch {
            stateDelegation?.unSubscribeStateHandler()
            getController().destroyReducer()
            getController().getVortexStore()?.destroyStore()
        }
        super.onDestroy()
    }

}
