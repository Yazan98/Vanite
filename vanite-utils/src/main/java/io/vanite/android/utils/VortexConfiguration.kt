package io.vanite.android.utils

import android.app.Application
import android.os.StrictMode
import androidx.appcompat.app.AppCompatDelegate
import io.vanite.android.errors.VaniteFirebaseConfigurationException
import io.vanite.android.keys.ImageLoader
import io.vanite.android.keys.LoggerType
import io.vanite.android.models.VanitePrefsDetails
import io.vanite.android.permissions.VortexPermissionsConfiguration
import io.vanite.android.prefs.VortexPrefsConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:52 PM
 */

object VortexConfiguration : VortexConfigurationImpl<LoggerType, ImageLoader> {

    private var applicationStatus: Boolean = false
    private lateinit var vortexApplication: Application
    private var isPlatformCheckRequired: Boolean = false

    override fun registerApplicationClass(app: Application): VortexConfiguration {
        vortexApplication = app
        return this
    }

    override suspend fun registerApplicationLogger(logger: LoggerType): VortexConfiguration {
        withContext(Dispatchers.IO) {
            when (logger) {
                LoggerType.TIMBER -> {
                    if (applicationStatus) {
                        Timber.plant(Timber.DebugTree())
                    }
                }

                LoggerType.VORTEX_LOGGER -> {
                    // implement this when create logger library (at the future xD )
                }
            }
        }
        return this
    }

    @Deprecated(
        "Not Used Anymore, if You Want to Add Image Library Confiuration Should be From App Side Not Library Side",
        ReplaceWith("Self Implementation in App Class Inside The Application")
    )
    override suspend fun registerImageLoader(imageLoader: ImageLoader): VortexConfiguration {
        return this
    }

    override suspend fun registerApplicationState(state: Boolean): VortexConfiguration {
        withContext(Dispatchers.IO) {
            applicationStatus = state
        }
        return this
    }

    @Deprecated(
        "Not Used Anymore, Declare Firebase from Your App Class",
        ReplaceWith("ManualDeclaration")
    )
    @Throws(VaniteFirebaseConfigurationException::class)
    override suspend fun registerFirebaseConfiguration(moduleName: String): VortexConfiguration {
        return this
    }

    override suspend fun registerStrictMode(): VortexConfiguration {
        withContext(Dispatchers.IO) {
            if (applicationStatus) {
                StrictMode.setThreadPolicy(
                    StrictMode.ThreadPolicy.Builder()
                        .detectAll()
                        .build()
                )
                StrictMode.setVmPolicy(
                    StrictMode.VmPolicy.Builder()
                        .detectLeakedSqlLiteObjects()
                        .penaltyLog()
                        .penaltyDeath()
                        .build()
                )
            }
        }
        return this
    }

    override suspend fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): VortexConfiguration {
        withContext(Dispatchers.IO) {
            Thread.currentThread().uncaughtExceptionHandler = handler
        }
        return this
    }

    override suspend fun registerCompatVector(): VortexConfiguration {
        withContext(Dispatchers.IO) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
        return this
    }

    @Deprecated("Moved to Firebase Crashlytics", ReplaceWith("FirebaseCrashlytics"))
    override suspend fun registerFabric(): VortexConfiguration {
        return this
    }

    override suspend fun checkPlatformRequiredConfiguration(): VortexConfiguration {
        isPlatformCheckRequired = true
        return this
    }

    override fun registerVortexPrefsConfiguration(
        details: VanitePrefsDetails,
        application: Application
    ): VortexConfiguration {
        VortexPrefsConfig.init(
            application.applicationContext,
            application.packageName
        )
        return this
    }

    override suspend fun registerUserStoryConfiguration(): VortexConfiguration {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun registerVortexPermissionsSettings(): VortexConfiguration {
        withContext(Dispatchers.IO) {
            VortexPermissionsConfiguration.attachApplication(vortexApplication)
        }
        return this
    }

}
