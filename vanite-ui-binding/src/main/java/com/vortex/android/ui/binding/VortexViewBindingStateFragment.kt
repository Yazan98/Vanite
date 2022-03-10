package com.vortex.android.ui.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import io.vortex.android.VortexAction
import io.vortex.android.VortexRxStore
import io.vortex.android.base.VortexViewModel
import io.vortex.android.state.VortexState
import io.vortex.android.ui.VortexErrorType
import io.vortex.android.ui.VortexViewImpl
import io.vortex.android.ui.fragment.VortexBaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Base Class in UI Level for Binding Views in Fragments
 * By ViewBinding Inflate and ViewModel
 *
 * Use This Type of Fragments Only if You Want to Use ViewBinding
 * This Class Has all Specific Classes in UI Layer
 * and Remove The Code For Layout Inflation by Using isScreenLayoutBinding()
 *
 * Same As @see VortexViewBindingFragment
 * The New Thing Here is This Fragment Has State, Action, Reducer
 * To Manage Specific Actions
 */
abstract class VortexViewBindingStateFragment<ViewBindingType : ViewBinding, State : VortexState, Action : VortexAction, Reducer : VortexViewModel<State, Action>>(private val inflate: Inflate<ViewBindingType>) : VortexBaseFragment(), VortexRxStore.VortexStateListener<State>,
    VortexViewImpl<Action, State, Reducer> {

    protected var binding: ViewBindingType? = null
    abstract val viewModel: Reducer

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = inflate.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeListeners()
        setupViewsListeners()
        onScreenStarted(view, savedInstanceState)
    }

    override fun getController(): Reducer {
        return viewModel
    }

    @CallSuper
    protected open fun subscribeListeners() {
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

    override fun initScreen(view: View) = Unit

    protected open fun setupViewsListeners() = Unit

    protected open fun onScreenStarted(view: View, savedInstanceState: Bundle?) = Unit

    override fun isScreenLayoutBinding(): Boolean {
        return false
    }

    override fun getLayoutRes(): Int {
        return 0
    }

}
