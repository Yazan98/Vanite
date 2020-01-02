package io.vortex.android.ui.fragment

import io.vortex.android.VortexAction
import io.vortex.android.VortexRxStore
import io.vortex.android.reducer.VortexReducer
import io.vortex.android.state.VortexState
import io.vortex.android.ui.VortexViewImpl

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:51 AM
 */

abstract class VortexFragment<State : VortexState, Action : VortexAction, Reducer : VortexReducer<State, Action>> :
    VortexBaseFragment(), VortexRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer>

