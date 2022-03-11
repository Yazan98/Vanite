package io.vanite.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import io.vanite.android.keys.VaniteViewModelState
import io.vanite.android.base.VaniteViewModelReadyState
import kotlinx.coroutines.launch

/**
 * This ViewModel Type is Only To Pass ViewModel with ReadyState Generic Type and Layout In Constructor
 *
 * Note: Full Implementation in VaniteFragment, VaniteBaseFragment
 */
abstract class VaniteFragmentReadyState<VM: VaniteViewModelReadyState>(@LayoutRes private val layoutRes: Int) : VaniteBaseFragment() {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getController().getStateHandler().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                onStateChanged(it)
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    protected abstract suspend fun onStateChanged(newState: VaniteViewModelState)
    protected abstract fun getController(): VM
    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
