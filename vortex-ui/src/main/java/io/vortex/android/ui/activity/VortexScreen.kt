package io.vortex.android.ui.activity

import android.os.Bundle
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
 * Time : 11:34 AM
 */

abstract class VortexScreen<State : VortexState, Action : VortexAction, Reducer : VortexReducer<State, Action>> :
    VortexBaseScreen(), VortexRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    private var stateDelegation: VortexStateDelegate<State>? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            stateDelegation = VortexStateDelegate<State>(getController().getVortexStore() as VortexStore<State>)
            stateDelegation.apply {
                this?.commitStoreHandler(this@VortexScreen)
                this?.subscribeStateHandler(this@VortexScreen)
                this?.subscribeLoadingHandler(this@VortexScreen)
            }

            getController().getVortexStore().apply {
                this.attachStateListener(this@VortexScreen)
            }
        }
    }

    override fun onDestroy() {
        GlobalScope.launch {
            stateDelegation?.unSubscribeStateHandler()
            getController().destroyReducer()
            getController().getVortexStore().destroyStore()
        }
        super.onDestroy()
    }

}