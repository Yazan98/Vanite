package io.vortex.android.prefs

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:49 PM
 */

object VortexPrefs {

    private val prefsEditor: SharedPreferences.Editor by lazy {
        VortexPrefsConfig.prefs.edit()
    }

    suspend fun put(key: String, value: Any) {
        withContext(Dispatchers.IO) {
            when (value) {
                is String -> prefsEditor.putString(key, value)
                is Long -> prefsEditor.putLong(key, value)
                is Float -> prefsEditor.putFloat(key, value)
                is Boolean -> prefsEditor.putBoolean(key, value)
                is Int -> prefsEditor.putInt(key, value)
                else -> {
                }
            }
            prefsEditor.commit()
        }
    }

    suspend fun get(key: String, defVal: Any): Any? {
        return withContext(Dispatchers.IO) {
            when (defVal) {
                is String -> VortexPrefsConfig.prefs.getString(key, defVal) as Any
                is Long -> VortexPrefsConfig.prefs.getLong(key, defVal)
                is Float -> VortexPrefsConfig.prefs.getFloat(key, defVal)
                is Boolean -> VortexPrefsConfig.prefs.getBoolean(key, defVal)
                is Int -> VortexPrefsConfig.prefs.getInt(key, defVal)
                else -> {
                }
            }
        }
    }

    suspend fun getAccessToken(): String? {
        return get(VortexPrefsConsts.ACCESS_TOKEN_KEY, "") as String
    }

    suspend fun saveAccessToken(token: String) {
        withContext(Dispatchers.IO) {
            put(VortexPrefsConsts.ACCESS_TOKEN_KEY, token)
        }
    }

    suspend fun getSelectedLanguage(): String? {
        return get(VortexPrefsConsts.LANGUAGE, "") as String
    }

    suspend fun saveSelectedLanguage(language: String) {
        withContext(Dispatchers.IO) {
            put(VortexPrefsConsts.LANGUAGE, language)
        }
    }

    suspend fun getUserStatus(): Boolean? {
        return get(VortexPrefsConsts.USER_STATUS, "") as Boolean
    }

    suspend fun saveUserStatus(status: Boolean) {
        withContext(Dispatchers.IO) {
            put(VortexPrefsConsts.USER_STATUS, status)
        }
    }

}
