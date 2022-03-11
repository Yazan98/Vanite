package io.vanite.android.ui.fragment

import io.vanite.android.VaniteAction
import io.vanite.android.VaniteRxStore
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState
import io.vanite.android.ui.VaniteLoadingStateView


abstract class VaniteLceFragment<State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>>
    : VaniteFragment<State, Action, Reducer>(), VaniteRxStore.VaniteStateListener<State>, VaniteLoadingStateView<Action, State, Reducer> {

    // Code at the Super Class

}
