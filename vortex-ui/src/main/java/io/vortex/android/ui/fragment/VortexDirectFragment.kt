package io.vortex.android.ui.fragment

import androidx.annotation.LayoutRes
import io.vortex.android.VortexAction
import io.vortex.android.VortexRxStore
import io.vortex.android.base.VortexViewModel
import io.vortex.android.state.VortexState
import io.vortex.android.ui.VortexViewImpl

abstract class VortexDirectFragment<State : VortexState, Action : VortexAction, Reducer : VortexViewModel<State, Action>>
    constructor(@LayoutRes private val layoutRes: Int) : VortexFragment<State, Action, Reducer>(), VortexRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
