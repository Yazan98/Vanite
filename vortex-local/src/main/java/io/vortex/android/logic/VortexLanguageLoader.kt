package io.vortex.android.logic

import android.content.Context
import android.content.SharedPreferences
import io.vortex.android.logic.impl.LoaderImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:13 PM
 */

class VortexLanguageLoader(private val context: Context) : LoaderImpl {

    private var sharedPrefs: SharedPreferences = context.getSharedPreferences(SP_LOCALE, Context.MODE_PRIVATE)
    private var language = Locale("en")

    companion object {
        private const val SP_LOCALE = "Vortex.VortexLanguageManager"
        private const val KEY_LANGUAGE = "language"
        private const val KEY_COUNTRY = "country"
        private const val KEY_VARIANT = "variant"
    }

    override suspend fun load(): Locale {
        return withContext(Dispatchers.IO) {
            sharedPrefs.getString(KEY_LANGUAGE, "")?.let {
                if (it.isEmpty()) {
                    language = Locale(it,
                        sharedPrefs.getString(KEY_COUNTRY, ""),
                        sharedPrefs.getString(KEY_VARIANT, "")
                    );
                }
            }
            return@withContext language
        }
    }

    override suspend fun save(locale: Locale) {
        withContext(Dispatchers.IO) {
            sharedPrefs.edit()
                .putString(KEY_LANGUAGE, locale.language)
                .putString(KEY_COUNTRY, locale.country)
                .putString(KEY_VARIANT, locale.variant)
                .apply()
        }
    }

    override suspend fun destroyLoader() {
        withContext(Dispatchers.IO) {
            sharedPrefs.edit().clear().apply()
        }
    }

}