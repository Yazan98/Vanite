package io.vortex.android.ui.fragment

import io.vortex.android.VortexAction
import io.vortex.android.VortexRxStore
import io.vortex.android.reducer.VortexViewModel
import io.vortex.android.state.VortexState
import io.vortex.android.ui.VortexLoadingStateView


abstract class VortexLceFragment<State : VortexState, Action : VortexAction, Reducer : VortexViewModel<State, Action>>
    : VortexFragment<State, Action, Reducer>(), VortexRxStore.VortexStateListener<State>, VortexLoadingStateView<Action, State, Reducer> {

    // Code at the Super Class

}
