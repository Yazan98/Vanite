package io.vanite.android.ui

import io.vanite.android.VaniteAction
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:37 AM
 */

interface VaniteViewImpl<Action : VaniteAction, State : VaniteState, Reducer : VaniteViewModel<State, Action>> {

    fun getController(): Reducer

    suspend fun getLoadingState(newState: Boolean)

}

interface VaniteLoadingStateView<Action : VaniteAction, State : VaniteState, Reducer : VaniteViewModel<State, Action>>: VaniteViewImpl<Action, State, Reducer> {
    suspend fun onLoadingChanged(status: Boolean)
}
