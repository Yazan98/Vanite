package com.vanite.android.ui.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import io.vanite.android.VaniteAction
import io.vanite.android.VaniteRxStore
import io.vanite.android.base.VaniteViewModel
import io.vanite.android.state.VaniteState
import io.vanite.android.ui.VaniteErrorType
import io.vanite.android.ui.VaniteViewImpl
import io.vanite.android.ui.fragment.VaniteBaseFragment
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
 * Same As @see VaniteViewBindingFragment
 * The New Thing Here is This Fragment Has State, Action, Reducer
 * To Manage Specific Actions
 */
abstract class VaniteViewBindingStateFragment<ViewBindingType : ViewBinding, State : VaniteState, Action : VaniteAction, Reducer : VaniteViewModel<State, Action>>(private val inflate: Inflate<ViewBindingType>) : VaniteBaseFragment(), VaniteRxStore.VaniteStateListener<State>,
    VaniteViewImpl<Action, State, Reducer> {

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

        getController().getEffectStateHandler().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                onEffectChanged(it)
            }
        }

        getController().getLoadingStateHandler().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                getLoadingState(it.getLoadingState())
            }
        })
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
