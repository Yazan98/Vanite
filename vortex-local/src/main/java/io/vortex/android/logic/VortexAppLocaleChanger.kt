package io.vortex.android.logic

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:30 PM
 */

class VortexAppLocaleChanger(private val context: Context) {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun updateConfiguration(newLocale: Locale) {
        context.resources.configuration.setLocale(newLocale);
    }

    private fun updateConfigurationLegacy(newLocale: Locale) {
        val conf = context.resources.configuration;
        conf.locale = newLocale
        context.resources.updateConfiguration(conf, context.resources.displayMetrics);
    }

    fun configureBaseContext(context: Context,locale: Locale): Context {
        return if (hasJellyBeanMr1()) {
            getLocaleConfiguredContext(context, locale)
        } else {
            context
        }
    }

    fun change(newLocale: Locale?) {
        newLocale?.let {
            Locale.setDefault(it)
            if (hasNougat()) updateConfiguration(it) else updateConfigurationLegacy(it)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun getLocaleConfiguredContext(context: Context,locale: Locale): Context {
        val conf = context.resources.configuration
        conf.setLocale(locale)
        return context.createConfigurationContext(conf)
    }

    companion object {
        internal fun hasNougat(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
        }

        internal fun hasJellyBeanMr1(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
        }
    }

}
