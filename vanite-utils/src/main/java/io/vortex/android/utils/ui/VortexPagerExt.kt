package io.vortex.android.utils.ui

import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.vortexIdSelection(listener: VortexPagerSelectionListener) {
    setOnNavigationItemSelectedListener { item ->
        listener.onSelected(item.itemId)
        true
    }
}

fun ViewPager.vortexPositionSelection(listener: VortexViewPagerSelectionListener) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) = Unit
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
        override fun onPageSelected(position: Int) {
            listener.onPageSelected(position)
        }
    })
}

interface VortexPagerSelectionListener {
    fun onSelected(id: Int)
}

interface VortexViewPagerSelectionListener {
    fun onPageSelected(position: Int)
}
