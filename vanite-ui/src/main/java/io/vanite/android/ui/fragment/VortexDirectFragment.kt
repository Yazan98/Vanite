package io.vanite.android.ui.fragment

import androidx.annotation.LayoutRes
import io.vanite.android.VaniteAction
import io.vanite.android.VaniteRxStore
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState
import io.vanite.android.ui.VortexViewImpl

/**
 * This Fragment Type is The Same as VortexFragment With State, Action, Reducer
 * The Only New Thing Here is getLayoutRes is Now Passed in Parameter not Self Implementation
 * In Sub Class
 *
 * Note: Full Implementation in VortexFragment, VortexBaseFragment
 */
abstract class VortexDirectFragment<State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>>
    constructor(@LayoutRes private val layoutRes: Int) : VortexFragment<State, Action, Reducer>(), VaniteRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
