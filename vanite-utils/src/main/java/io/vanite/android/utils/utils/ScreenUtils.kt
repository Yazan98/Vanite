package io.vanite.android.utils.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:53 AM
 */

object ScreenUtils {

    private var configuration: Configuration? = null

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.screenLayout and SCREENLAYOUT_SIZE_MASK >= SCREENLAYOUT_SIZE_LARGE
    }

    fun hasSmallScreen(context: Context): Boolean {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_SMALL
    }

    fun hasNormalScreen(context: Context): Boolean {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_NORMAL
    }

    fun hasLargeScreen(context: Context): Boolean {
        return getScreenSize(context) == SCREENLAYOUT_SIZE_LARGE
    }

    private fun getScreenSize(context: Context): Int {
        configuration = context.resources.configuration
        return configuration!!.screenLayout and SCREENLAYOUT_SIZE_MASK
    }

}