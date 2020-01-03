package io.vortex.android.logic

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 1/3/2020
 * Time : 2:23 AM
 */

class VortexLanguageStore(context: Context) {

    companion object {
        const val SHARED_PREFS_KEY = "VortexSharedPrefsLanguage"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFS_KEY , Context.MODE_PRIVATE)
    }

    suspend fun saveNewLanguage(newLanguage: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit().putString("VortexCurrentLanguage" , newLanguage).apply()
        }
    }

    suspend fun getCurrentLanguage(): String {
        return withContext(Dispatchers.IO) {
            sharedPreferences.getString("VortexCurrentLanguage" , "en")
        }.toString()
    }

}
