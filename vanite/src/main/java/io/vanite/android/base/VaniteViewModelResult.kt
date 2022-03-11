package io.vanite.android.base

import io.vanite.android.VaniteAction
import io.vanite.android.VaniteViewModelType
import io.vanite.android.rx.VaniteRequestProvider
import io.vanite.android.state.VaniteState

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:15 PM
 */

/**
 * This ViewModel Type Used To Build ViewModel With Specific Api Response and Access
 * VaniteRequestProvider Directly Without Create it from Sub Class
 *
 * Note: Full Implementation of An Vanite ViewModel With State, Action, RxJava is Available at @see VaniteViewModel
 */
abstract class VaniteViewModelResult<State : VaniteState, Action : VaniteAction , Result> : VaniteViewModel<State, Action>(),
    VaniteViewModelType {

    protected fun getRequestProvider(): VaniteRequestProvider<Result> = VaniteRequestProvider<Result>()

}
