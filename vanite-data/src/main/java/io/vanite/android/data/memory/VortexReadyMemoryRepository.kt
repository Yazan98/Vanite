package io.vanite.android.data.memory

import android.content.SharedPreferences

object VortexReadyMemoryRepository : VortexMemoryRepository() {

    private val prefsEditor: SharedPreferences.Editor by lazy {
        VortexReadyMemoryInitializer.prefs.edit()
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
            is String -> VortexReadyMemoryInitializer.prefs.getString(key, defVal) as Any
            is Long -> VortexReadyMemoryInitializer.prefs.getLong(key, defVal)
            is Float -> VortexReadyMemoryInitializer.prefs.getFloat(key, defVal)
            is Boolean -> VortexReadyMemoryInitializer.prefs.getBoolean(key, defVal)
            is Int -> VortexReadyMemoryInitializer.prefs.getInt(key, defVal)
            else -> {
            }
        }
    }

}
