package io.vortex.android.ui

import io.vortex.android.VortexAction
import io.vortex.android.reducer.VortexViewModel
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:37 AM
 */

interface VortexViewImpl<Action : VortexAction, State : VortexState, Reducer : VortexViewModel<State, Action>> {

    suspend fun getController(): Reducer

    suspend fun getLoadingState(newState: Boolean)

}
