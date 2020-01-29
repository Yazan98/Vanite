package io.vortex.android.logic

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*


/**
 * Created By : Yazan Tarifi
 * Date : 1/3/2020
 * Time : 2:21 AM
 */

object VortexAppLanguage {

    suspend fun saveCurrentLanguage(context: Context, newLanguage: String) {
        withContext(Dispatchers.IO) {
            val store = VortexLanguageStore(context)
            store.saveNewLanguage(newLanguage)
            changeApplicationLanguage(context, newLanguage)
        }
    }



    suspend fun getCurrentLanguage(context: Context): String {
        return VortexLanguageStore(context).getCurrentLanguage()
    }

    private suspend fun changeApplicationLanguage(context: Context, newLanguage: String) {
        withContext(Dispatchers.Main) {
            val config = context.resources.configuration;
            val sysLocale: Locale? = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                getSystemLocale(config)
            } else {
                getSystemLocaleLegacy(config)
            }
            sysLocale?.let {
                if (!newLanguage.equals("") && !it.language.equals(newLanguage)) {
                    val locale = Locale(newLanguage);
                    Locale.setDefault(locale);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        setSystemLocale(config, locale);
                    } else {
                        setSystemLocaleLegacy(config, locale);
                    }

                }
                context.createConfigurationContext(config)
            }
        }
    }

    private fun getSystemLocaleLegacy(config: Configuration): Locale? {
        return config.locale
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun getSystemLocale(config: Configuration): Locale? {
        return config.locales[0]
    }

    private fun setSystemLocaleLegacy(config: Configuration, locale: Locale?) {
        config.locale = locale
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun setSystemLocale(config: Configuration, locale: Locale?) {
        config.setLocale(locale)
    }

    suspend fun attachBaseContext(context: Context, defLanguage: String) {
        withContext(Dispatchers.Main) {
            changeApplicationLanguage(context, defLanguage)
        }
    }

    fun getDeviceVersion(): Int = Build.VERSION.SDK_INT

}