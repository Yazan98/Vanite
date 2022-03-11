package io.vanite.android.utils

import android.app.Application
import android.os.StrictMode
import androidx.appcompat.app.AppCompatDelegate
import io.vanite.android.errors.VaniteFirebaseConfigurationException
import io.vanite.android.keys.ImageLoader
import io.vanite.android.keys.LoggerType
import io.vanite.android.models.VanitePrefsDetails
import io.vanite.android.permissions.VanitePermissionsConfiguration
import io.vanite.android.prefs.VanitePrefsConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:52 PM
 */

object VaniteConfiguration : VaniteConfigurationImpl<LoggerType, ImageLoader> {

    private var applicationStatus: Boolean = false
    private lateinit var vaniteApplication: Application
    private var isPlatformCheckRequired: Boolean = false

    override fun registerApplicationClass(app: Application): VaniteConfiguration {
        vaniteApplication = app
        return this
    }

    override suspend fun registerApplicationLogger(logger: LoggerType): VaniteConfiguration {
        withContext(Dispatchers.IO) {
            when (logger) {
                LoggerType.TIMBER -> {
                    if (applicationStatus) {
                        Timber.plant(Timber.DebugTree())
                    }
                }

                LoggerType.VANITE_LOGGER -> {
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
    override suspend fun registerImageLoader(imageLoader: ImageLoader): VaniteConfiguration {
        return this
    }

    override suspend fun registerApplicationState(state: Boolean): VaniteConfiguration {
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
    override suspend fun registerFirebaseConfiguration(moduleName: String): VaniteConfiguration {
        return this
    }

    override suspend fun registerStrictMode(): VaniteConfiguration {
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

    override suspend fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): VaniteConfiguration {
        withContext(Dispatchers.IO) {
            Thread.currentThread().uncaughtExceptionHandler = handler
        }
        return this
    }

    override suspend fun registerCompatVector(): VaniteConfiguration {
        withContext(Dispatchers.IO) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
        return this
    }

    @Deprecated("Moved to Firebase Crashlytics", ReplaceWith("FirebaseCrashlytics"))
    override suspend fun registerFabric(): VaniteConfiguration {
        return this
    }

    override suspend fun checkPlatformRequiredConfiguration(): VaniteConfiguration {
        isPlatformCheckRequired = true
        return this
    }

    override fun registerVanitePrefsConfiguration(
        details: VanitePrefsDetails,
        application: Application
    ): VaniteConfiguration {
        VanitePrefsConfig.init(
            application.applicationContext,
            application.packageName
        )
        return this
    }

    override suspend fun registerUserStoryConfiguration(): VaniteConfiguration {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun registerVanitePermissionsSettings(): VaniteConfiguration {
        withContext(Dispatchers.IO) {
            VanitePermissionsConfiguration.attachApplication(vaniteApplication)
        }
        return this
    }

}
