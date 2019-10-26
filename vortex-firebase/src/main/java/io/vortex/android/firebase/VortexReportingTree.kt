package io.vortex.android.firebase

import timber.log.Timber
import android.R.id.message
import android.R.attr.priority
import android.util.Log
import com.crashlytics.android.Crashlytics
import com.google.firebase.crash.FirebaseCrash


/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:09 PM
 */

class VortexReportingTree : Timber.Tree() {

    private val CRASHLYTICS_KEY_PRIORITY = "priority"
    private val CRASHLYTICS_KEY_TAG = "tag"
    private val CRASHLYTICS_KEY_MESSAGE = "message"

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        val t = t ?: Exception(message)

        Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority)
        Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag)
        Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message)
        Crashlytics.logException(t)

        // Firebase Crash Reporting
        FirebaseCrash.logcat(priority, tag, message)
        FirebaseCrash.report(t)
    }
}