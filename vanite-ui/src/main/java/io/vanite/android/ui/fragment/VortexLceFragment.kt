package io.vanite.android.ui.fragment

import io.vanite.android.VaniteAction
import io.vanite.android.VaniteRxStore
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState
import io.vanite.android.ui.VortexLoadingStateView


abstract class VortexLceFragment<State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>>
    : VortexFragment<State, Action, Reducer>(), VaniteRxStore.VortexStateListener<State>, VortexLoadingStateView<Action, State, Reducer> {

    // Code at the Super Class

}
