package io.vanite.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import io.vanite.android.VaniteAction
import io.vanite.android.VaniteRxStore
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState
import io.vanite.android.ui.VortexErrorType
import io.vanite.android.ui.VortexViewImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:51 AM
 */

/**
 * This Class is The Main Fragment In Vortex and it's Recommended to Only Fragments that is Using
 * XML Binding and This is a Managed Class in onViewCreated that will Use Action, State, Reducer
 */
abstract class VortexFragment<State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>> :
    VortexBaseFragment(), VaniteRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getController().getStateHandler().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                onStateChanged(it)
            }
        })

        getController().getLoadingStateHandler().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                getLoadingState(it.getLoadingState())
            }
        })
        super.onViewCreated(view, savedInstanceState)
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
