package com.vanite.android.ui.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import io.vanite.android.ui.fragment.VaniteBaseFragment

abstract class VaniteViewBindingSingleFragment<ViewBindingType : ViewBinding>(private val inflate: Inflate<ViewBindingType>) : VaniteBaseFragment() {

    protected var binding: ViewBindingType? = null

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

    protected open fun subscribeListeners() = Unit

    protected open fun setupViewsListeners() = Unit

    protected open fun onScreenStarted(view: View, savedInstanceState: Bundle?) = Unit

    override fun isScreenLayoutBinding(): Boolean {
        return false
    }

    override fun getLayoutRes(): Int {
        return 0
    }

}
