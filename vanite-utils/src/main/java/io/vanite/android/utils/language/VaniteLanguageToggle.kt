package io.vanite.android.utils.language

import android.content.Context
import android.content.SharedPreferences
import io.vanite.android.details.VanitePrefsDetails
import io.vanite.android.details.VanitePrefsDetailsException
import io.vanite.android.errors.VanitePrefsNotInitializedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:39 AM
 */

object VortexLanguageToggle {

    lateinit var prefs: SharedPreferences

    suspend fun init(context: Context, packageName: String) {
        withContext(Dispatchers.IO) {
            prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
        }
    }

    suspend fun saveSelectedLanguage(language: String) {
        withContext(Dispatchers.IO) {
            if (::prefs.isInitialized) {
                prefs.edit().putString("AttoSelectedLanguage", language).apply()
            } else {
                VanitePrefsNotInitializedException(VanitePrefsDetailsException<VanitePrefsDetails>(
                    "Vortex Prefs Not Initialized",
                    VanitePrefsDetails(
                        "io.vortex.android.utils.language.VortexLanguageToggle",
                        "This Error Happend When You Forget To Call VortexLanguageToggle.init(context)"
                    )
                ))
            }
        }
    }

    suspend fun getSelectedLanguage(): String? {
        return withContext(Dispatchers.IO) {
            prefs.getString("AttoSelectedLanguage", null)
        }
    }

    suspend fun changeApplicationLanguage(newLanguage: String, context: Context?) {
        withContext(Dispatchers.IO) {
            context?.let {
                val resources = it.resources
                val locale = Locale(newLanguage)
                Locale.setDefault(locale)
                val config = android.content.res.Configuration()
                config.setLocale(locale)
                resources.updateConfiguration(config, resources.displayMetrics)
            }
        }
    }

}

suspend fun languagePreCondition(context: Context?) {
    withContext(Dispatchers.IO) {
        VortexLanguageToggle.getSelectedLanguage()?.let {
            VortexLanguageToggle.changeApplicationLanguage(it, context)
        }
    }

}
