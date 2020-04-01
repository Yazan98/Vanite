package io.vortex.android.utils

import android.content.Context
import androidx.annotation.CallSuper
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.facebook.imagepipeline.core.ImageTranscoderType
import com.facebook.imagepipeline.core.MemoryChunkType
import io.vortex.android.models.ui.VortexNotificationDetails
import io.vortex.android.utils.random.TimberReleaseTree
import io.vortex.android.utils.random.VortexDeviceInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:49 AM
 */

open class VortexApplication : MultiDexApplication() {

    protected val notificationsController: VortexNotificationController by lazy {
        VortexNotificationController()
    }

    /**
     * When You Need To Show Notifications THe New Android Sdk Requires Notification Channel
     * To Show THis Notification For User And Here you are Initializing The Channels
     */
    protected suspend fun setupNotificationChannels(clannels: List<VortexNotificationDetails>) {
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
    protected suspend fun setupFresco() {
        withContext(Dispatchers.IO) {
            Fresco.initialize(
                applicationContext,
                ImagePipelineConfig.newBuilder(applicationContext)
                    .setMemoryChunkType(MemoryChunkType.BUFFER_MEMORY)
                    .setImageTranscoderType(ImageTranscoderType.JAVA_TRANSCODER)
                    .experiment().setNativeCodeDisabled(true)
                    .build()
            )
        }
    }

    /**
     * If (applicationState) is True Timber Should Print in Logcat if False
     * It should print on Crashlitycs
     */
    protected suspend fun setupTimber(applicationStatus: Boolean) {
        withContext(Dispatchers.IO) {
            if (applicationStatus) {
                Timber.plant(Timber.DebugTree())
            } else {
                Timber.plant(TimberReleaseTree())
            }
        }
    }

    @CallSuper
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    protected fun getDeviceInfo(): VortexDeviceInfo = VortexDeviceInfo(applicationContext)

}
