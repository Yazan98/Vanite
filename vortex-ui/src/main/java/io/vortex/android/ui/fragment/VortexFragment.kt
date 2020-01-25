package io.vortex.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import io.vortex.android.VortexAction
import io.vortex.android.VortexRxStore
import io.vortex.android.reducer.VortexViewModel
import io.vortex.android.state.VortexState
import io.vortex.android.ui.VortexErrorType
import io.vortex.android.ui.VortexViewImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:51 AM
 */

abstract class VortexFragment<State : VortexState, Action : VortexAction, Reducer : VortexViewModel<State, Action>> :
    VortexBaseFragment(), VortexRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalScope.launch {
            subscribeObservers()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private suspend fun subscribeObservers() {
        withContext(Dispatchers.Main) {
            getController().getStateHandler().observe(viewLifecycleOwner, Observer {
                GlobalScope.launch {
                    onStateChanged(it)
                }
            })

            getController().getLoadingStateHandler().observe(viewLifecycleOwner, Observer {
                GlobalScope.launch {
                    getLoadingState(it.getLoadingState())
                }
            })
        }
    }

    protected suspend fun showError(message: String?, type: VortexErrorType) {
        withContext(Dispatchers.Main) {
            activity?.let { context ->
                message?.let {
                    when (type) {
                        VortexErrorType.SHORT_TOAST -> messageController.showShortMessage(
                            message,
                            context
                        )
                        VortexErrorType.LONG_TOAST -> messageController.showLongMessage(
                            message,
                            context
                        )
                        VortexErrorType.SNACK_BAR -> messageController.showSnackbar(
                            context,
                            message
                        )
                    }
                }
            }
        }
    }

}
