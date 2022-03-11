package io.vanite.android.utils

import android.content.Context
import androidx.annotation.CallSuper
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import io.vanite.android.models.ui.VaniteNotificationDetails
import io.vanite.android.utils.random.VaniteDeviceInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:49 AM
 */

open class VaniteApplication : MultiDexApplication() {

    protected val notificationsController: VaniteNotificationController by lazy {
        VaniteNotificationController()
    }

    /**
     * When You Need To Show Notifications THe New Android Sdk Requires Notification Channel
     * To Show THis Notification For User And Here you are Initializing The Channels
     */
    protected suspend fun setupNotificationChannels(clannels: List<VaniteNotificationDetails>) {
        withContext(Dispatchers.IO) {
            applicationContext?.let {
                notificationsController.createMultiNotificationChannels(
                    clannels,
                    it
                )
            }
        }
    }

    /**
     * Setup Fresco Configuration
     * This Configuration Should Initialize Fresco On Background Thread With Buffer Memory
     */
    @Deprecated("Fresco Removed From Application", ReplaceWith("Glide Loading in  VaniteImageLoader"))
    protected suspend fun setupFresco() = Unit

    /**
     * If (applicationState) is True Timber Should Print in Logcat if False
     * It should print on Crashlitycs
     */
    protected suspend fun setupTimber(applicationStatus: Boolean) {
        withContext(Dispatchers.IO) {
            if (applicationStatus) {
                Timber.plant(Timber.DebugTree())
            }
        }
    }

    @CallSuper
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    protected fun getDeviceInfo(): VaniteDeviceInfo = VaniteDeviceInfo(applicationContext)

}
