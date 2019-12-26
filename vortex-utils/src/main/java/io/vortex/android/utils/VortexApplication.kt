package io.vortex.android.utils

import android.content.Context
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

    protected val notificationsController: VortexNotificationController by lazy {
        VortexNotificationController()
    }

    @CallSuper
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    protected fun getDeviceInfo(): VortexDeviceInfo = VortexDeviceInfo(applicationContext)

}
