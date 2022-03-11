package io.vanite.android.utils.ui

import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.vaniteIdSelection(listener: VanitePagerSelectionListener) {
    setOnNavigationItemSelectedListener { item ->
        listener.onSelected(item.itemId)
        true
    }
}

fun ViewPager.vanitePositionSelection(listener: VaniteViewPagerSelectionListener) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) = Unit
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
        override fun onPageSelected(position: Int) {
            listener.onPageSelected(position)
        }
    })
}

interface VanitePagerSelectionListener {
    fun onSelected(id: Int)
}

interface VaniteViewPagerSelectionListener {
    fun onPageSelected(position: Int)
}
