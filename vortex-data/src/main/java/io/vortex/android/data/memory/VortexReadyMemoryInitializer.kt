package io.vortex.android.data.memory

import android.content.Context
import android.content.SharedPreferences

object VortexReadyMemoryInitializer {

    lateinit var prefs: SharedPreferences

    fun init(context: Context, packageName: String) {
        prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }

}