package io.vanite.android.utils.utils

import android.webkit.WebView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:57 AM
 */

object VaniteBackPressedUtils {

    fun getViewPagerHandler(viewpager: ViewPager, context: FragmentActivity) {
        if (viewpager.currentItem == 0) {
            context.onBackPressed()
        } else {
            viewpager.currentItem = viewpager.currentItem - 1
        }
    }

    fun handleWebViewBack(webView: WebView, context: FragmentActivity) {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            context.onBackPressed()
        }
    }

}