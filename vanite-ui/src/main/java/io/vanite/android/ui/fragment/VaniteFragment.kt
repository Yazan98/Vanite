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
import io.vanite.android.ui.VaniteErrorType
import io.vanite.android.ui.VaniteViewImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:51 AM
 */

/**
 * This Class is The Main Fragment In Vanite and it's Recommended to Only Fragments that is Using
 * XML Binding and This is a Managed Class in onViewCreated that will Use Action, State, Reducer
 */
abstract class VaniteFragment<State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>> :
    VaniteBaseFragment(), VaniteRxStore.VaniteStateListener<State>,
    VaniteViewImpl<Action, State, Reducer> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getController().getStateHandler().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                onStateChanged(it)
            }
        }

        getController().getEffectStateHandler().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                onEffectChanged(it)
            }
        }

        getController().getLoadingStateHandler().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                getLoadingState(it.getLoadingState())
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }


    protected suspend fun showError(message: String?, type: VaniteErrorType) {
        withContext(Dispatchers.Main) {
            activity?.let { context ->
                message?.let {
                    when (type) {
                        VaniteErrorType.SHORT_TOAST -> messageController.showShortMessage(
                            message,
                            context
                        )
                        VaniteErrorType.LONG_TOAST -> messageController.showLongMessage(
                            message,
                            context
                        )
                        VaniteErrorType.SNACK_BAR -> messageController.showSnackbar(
                            context,
                            message
                        )
                    }
                }
            }
        }
    }

}
