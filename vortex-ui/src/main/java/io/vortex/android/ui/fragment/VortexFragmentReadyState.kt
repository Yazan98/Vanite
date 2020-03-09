package io.vortex.android.ui.fragment

import androidx.annotation.LayoutRes
import io.vortex.android.reducer.VortexViewModelReadyState

abstract class VortexFragmentReadyState<VM: VortexViewModelReadyState>(@LayoutRes private val layoutRes: Int) : VortexBaseFragment() {

    protected abstract fun getController(): VM
    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
