package io.vortex.android.base

import io.vortex.android.VortexAction
import io.vortex.android.VortexViewModelType
import io.vortex.android.rx.VortexRequestProvider
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:15 PM
 */

/**
 * This ViewModel Type Used To Build ViewModel With Specific Api Response and Access
 * VortexRequestProvider Directly Without Create it from Sub Class
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
abstract class VortexViewModelResult<State : VortexState, Action : VortexAction , Result> : VortexViewModel<State, Action>(),
    VortexViewModelType {

    protected fun getRequestProvider(): VortexRequestProvider<Result> = VortexRequestProvider<Result>()

}
