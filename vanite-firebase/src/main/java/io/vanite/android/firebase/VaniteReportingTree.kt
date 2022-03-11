package io.vanite.android.firebase

import android.util.Log
import timber.log.Timber


/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:09 PM
 */

abstract class VaniteReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        val t = t ?: Exception(message)
        onCrashLogged(t)
    }

    abstract fun onCrashLogged(ex: Throwable?)

}
