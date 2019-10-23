package io.vortex.android.utils.random

import android.util.Log
import androidx.annotation.Nullable
import com.crashlytics.android.Crashlytics
import timber.log.Timber

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:34 AM
 */

class TimberReleaseTree : Timber.Tree() {

    private val CRASHLYTICS_KEY_PRIORITY = "priority"
    private val CRASHLYTICS_KEY_TAG = "tag"
    private val CRASHLYTICS_KEY_MESSAGE = "message"

    override fun log(priority: Int, @Nullable tag: String?, @Nullable message: String, @Nullable t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return
        }

        Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority)
        Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag)
        Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message)

        if (t == null) {
            Crashlytics.logException(Exception(message))
        } else {
            Crashlytics.logException(t)
        }

    }

}