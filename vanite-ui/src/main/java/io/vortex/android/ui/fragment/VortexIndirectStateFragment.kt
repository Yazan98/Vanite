package io.vortex.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import io.vortex.android.base.VortexIndirectViewModel
import kotlinx.coroutines.launch

/**
 * This Fragment is Only Handling State Without Action Passed to Screen
 * Also The Layout is Not Required to be in Method
 * Can Be Passed in Parameters in the Constructor
 *

 */
abstract class VortexIndirectStateFragment<State, VM : VortexIndirectViewModel<State>>(@LayoutRes private val layoutId: Int) :
    VortexBaseFragment() {

    override fun getLayoutRes(): Int {
        return layoutId
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getController().getStateHandler().observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                onStateChanged(it)
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }

    protected abstract fun getController(): VM
    protected abstract fun onStateChanged(newState: State)

}
