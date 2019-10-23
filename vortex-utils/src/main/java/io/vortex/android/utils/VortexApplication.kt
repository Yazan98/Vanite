package io.vortex.android.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.CallSuper
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import io.vortex.android.utils.random.VortexDeviceInfo

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:49 AM
 */

open class VortexApplication : MultiDexApplication() {

    @CallSuper
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    protected fun createNotificationChannel(
        channelID: Int,
        channelDescription: Int,
        channelName: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(channelName)
            val descriptionText = getString(channelDescription)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(getString(channelID), name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    protected fun getDeviceInfo(): VortexDeviceInfo = VortexDeviceInfo(applicationContext)

}
