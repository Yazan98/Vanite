package io.vanite.android.ui.activity

import androidx.annotation.LayoutRes

abstract class VaniteDirectScreen(@LayoutRes private val layoutRes: Int) : VaniteScreen() {

    override fun getLayoutRes(): Int {
        return layoutRes
    }

}
