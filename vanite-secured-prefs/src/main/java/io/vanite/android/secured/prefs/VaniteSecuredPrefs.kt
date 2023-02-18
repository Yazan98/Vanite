package io.vanite.android.secured.prefs

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class VaniteSecuredPrefs constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val ACCESS_TOKEN_KEY = "AccessToken"
        private const val LANGUAGE = "LanguageSelected"
        private const val USER_STATUS = "UserStatus"
    }

    private val prefsEditor: SharedPreferences.Editor by lazy {
        sharedPreferences.edit()
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
                is String -> sharedPreferences.getString(key, defVal) as Any
                is Long -> sharedPreferences.getLong(key, defVal)
                is Float -> sharedPreferences.getFloat(key, defVal)
                is Boolean -> sharedPreferences.getBoolean(key, defVal)
                is Int -> sharedPreferences.getInt(key, defVal)
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
            is String -> sharedPreferences.getString(key, defVal) as Any
            is Long -> sharedPreferences.getLong(key, defVal)
            is Float -> sharedPreferences.getFloat(key, defVal)
            is Boolean -> sharedPreferences.getBoolean(key, defVal)
            is Int -> sharedPreferences.getInt(key, defVal)
            else -> {
            }
        }
    }

    suspend fun getAccessToken(): String? {
        return get(ACCESS_TOKEN_KEY, "") as String
    }

    suspend fun saveAccessToken(token: String) {
        withContext(Dispatchers.IO) {
            put(ACCESS_TOKEN_KEY, token)
        }
    }

    suspend fun getSelectedLanguage(): String? {
        return get(LANGUAGE, "") as String
    }

    suspend fun saveSelectedLanguage(language: String) {
        withContext(Dispatchers.IO) {
            put(LANGUAGE, language)
        }
    }

    suspend fun getUserStatus(): Boolean? {
        return get(USER_STATUS, false) as Boolean
    }

    suspend fun saveUserStatus(status: Boolean) {
        withContext(Dispatchers.IO) {
            put(USER_STATUS, status)
        }
    }

}