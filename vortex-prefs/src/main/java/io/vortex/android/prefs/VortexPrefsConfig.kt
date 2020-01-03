package io.vortex.android.prefs

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:50 PM
 */

object VortexPrefsConfig {

    lateinit var prefs: SharedPreferences

    fun init(context: Context, packageName: String) {
        prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }

}
