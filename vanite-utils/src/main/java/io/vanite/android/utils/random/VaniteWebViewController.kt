package io.vanite.android.utils.random

import android.graphics.Bitmap
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:48 AM
 */

open class VaniteWebViewController(private val progressBar: ProgressBar) : WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility = View.GONE
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        progressBar.visibility = View.VISIBLE
    }

}