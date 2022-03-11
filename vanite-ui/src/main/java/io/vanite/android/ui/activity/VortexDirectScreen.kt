package io.vanite.android.ui.activity

import androidx.annotation.LayoutRes

abstract class VortexDirectScreen(@LayoutRes private val layoutRes: Int) : VortexScreen() {

    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
