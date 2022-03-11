package io.vanite.android.data.memory

import android.content.Context
import android.content.SharedPreferences

object VaniteReadyMemoryInitializer {

    lateinit var prefs: SharedPreferences

    fun init(context: Context, packageName: String) {
        prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }

}