package com.vortex.android.ui.binding

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import io.vortex.android.ui.activity.VortexScreen

abstract class VortexViewBindingScreen<B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : VortexScreen() {

    protected var binding: B? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding?.root)
    }

    override fun isScreenLayoutBinding(): Boolean {
        return false
    }

    override fun getLayoutRes(): Int {
        return 0
    }

}