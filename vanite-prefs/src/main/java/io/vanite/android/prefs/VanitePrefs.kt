package io.vanite.android.prefs

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:49 PM
 */

object VanitePrefs {

    private val prefsEditor: SharedPreferences.Editor by lazy {
        VanitePrefsConfig.prefs.edit()
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
                is String -> VanitePrefsConfig.prefs.getString(key, defVal) as Any
                is Long -> VanitePrefsConfig.prefs.getLong(key, defVal)
                is Float -> VanitePrefsConfig.prefs.getFloat(key, defVal)
                is Boolean -> VanitePrefsConfig.prefs.getBoolean(key, defVal)
                is Int -> VanitePrefsConfig.prefs.getInt(key, defVal)
                else -> {
                }
            }
        }
    }

    fun putLocalKey(key: String, value: Any) {
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

    fun getLocalKey(key: String, defVal: Any): Any? {
        return when (defVal) {
            is String -> VanitePrefsConfig.prefs.getString(key, defVal) as Any
            is Long -> VanitePrefsConfig.prefs.getLong(key, defVal)
            is Float -> VanitePrefsConfig.prefs.getFloat(key, defVal)
            is Boolean -> VanitePrefsConfig.prefs.getBoolean(key, defVal)
            is Int -> VanitePrefsConfig.prefs.getInt(key, defVal)
            else -> {
            }
        }
    }

    suspend fun getAccessToken(): String? {
        return get(VanitePrefsConsts.ACCESS_TOKEN_KEY, "") as String
    }

    suspend fun saveAccessToken(token: String) {
        withContext(Dispatchers.IO) {
            put(VanitePrefsConsts.ACCESS_TOKEN_KEY, token)
        }
    }

    suspend fun getSelectedLanguage(): String? {
        return get(VanitePrefsConsts.LANGUAGE, "") as String
    }

    suspend fun saveSelectedLanguage(language: String) {
        withContext(Dispatchers.IO) {
            put(VanitePrefsConsts.LANGUAGE, language)
        }
    }

    suspend fun getUserStatus(): Boolean? {
        return get(VanitePrefsConsts.USER_STATUS, false) as Boolean
    }

    suspend fun saveUserStatus(status: Boolean) {
        withContext(Dispatchers.IO) {
            put(VanitePrefsConsts.USER_STATUS, status)
        }
    }

}
