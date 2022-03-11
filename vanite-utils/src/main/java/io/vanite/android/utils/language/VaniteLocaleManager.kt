package io.vanite.android.utils.language

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.preference.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:45 AM
 */

object VaniteLocaleManager {

    val SELECTED_LANGUAGE = "Locale.Language"

    fun onAttach(context: Context): Context {
        val lang = getPersistedData(context, Locale.getDefault().language)
        return setLocale(context, lang)
    }

    fun onAttach(context: Context, defaultLanguage: String): Context {
        val lang = getPersistedData(context, defaultLanguage)
        return setLocale(context, lang)
    }

    fun getLanguage(context: Context): String? {
        return getPersistedData(context, Locale.getDefault().language)
    }


    fun setLocale(context: Context, language: String?): Context {
        persist(context, language)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, language)
        } else updateResourcesLegacy(context, language)

    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)
    }

    private fun persist(context: Context, language: String?) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, language: String?): Context {

        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources

        val configuration = resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)

        resources.updateConfiguration(configuration, resources.displayMetrics)

        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(context: Context, language: String?): Context {
        val locale = Locale(language)
        //        Locale.setDefault(locale);
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }

    fun isLanguageEn(context: Context): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(
            SELECTED_LANGUAGE,
            "en"
        ) == "en"
    }

    suspend fun selectLanguage(language: String, context: Context) {
        withContext(Dispatchers.IO) {
            setLocale(context, language)
        }
    }

}