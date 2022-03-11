package io.vanite.android.data.memory

import android.content.SharedPreferences

object VaniteReadyMemoryRepository : VaniteMemoryRepository() {

    private val prefsEditor: SharedPreferences.Editor by lazy {
        VaniteReadyMemoryInitializer.prefs.edit()
    }

    override fun getByKey(key: String, defVal: String): Any? {
        return getLocalKey(key, defVal)
    }

    override fun save(key: String, value: Any) {
        putLocalKey(key, value)
    }

    private fun putLocalKey(key: String, value: Any) {
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

    private fun getLocalKey(key: String, defVal: Any): Any? {
        return when (defVal) {
            is String -> VaniteReadyMemoryInitializer.prefs.getString(key, defVal) as Any
            is Long -> VaniteReadyMemoryInitializer.prefs.getLong(key, defVal)
            is Float -> VaniteReadyMemoryInitializer.prefs.getFloat(key, defVal)
            is Boolean -> VaniteReadyMemoryInitializer.prefs.getBoolean(key, defVal)
            is Int -> VaniteReadyMemoryInitializer.prefs.getInt(key, defVal)
            else -> {
            }
        }
    }

}
