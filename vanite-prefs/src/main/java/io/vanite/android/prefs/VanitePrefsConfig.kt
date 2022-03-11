package io.vanite.android.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:50 PM
 */

object VanitePrefsConfig {

    lateinit var prefs: SharedPreferences

    fun init(context: Context, packageName: String) {
        prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }

}
