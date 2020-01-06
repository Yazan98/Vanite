package io.vortex.android.utils

import android.app.Application
import android.os.Handler
import android.os.StrictMode
import androidx.appcompat.app.AppCompatDelegate
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.answers.Answers
import com.crashlytics.android.core.CrashlyticsCore
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import io.fabric.sdk.android.Fabric
import io.vortex.android.keys.ImageLoader
import io.vortex.android.keys.LoggerType
import io.vortex.android.details.FirebaseAppException
import io.vortex.android.details.VortexFirebaseDetailsException
import io.vortex.android.errors.VortexFirebaseConfigurationException
import io.vortex.android.models.VortexPrefsDetails
import io.vortex.android.permissions.VortexPermissionsConfiguration
import io.vortex.android.prefs.VortexPrefsConfig
import io.vortex.android.utils.random.TimberReleaseTree
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import leakcanary.LeakSentry
import timber.log.Timber
import java.io.File

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
                    } else {
                        Timber.plant(TimberReleaseTree())
                    }
                }

                LoggerType.VORTEX_LOGGER -> {
                    // implement this when create logger library (at the future xD )
                }
            }
        }
        return this
    }

    override suspend fun registerImageLoader(imageLoader: ImageLoader): VortexConfiguration {
        withContext(Dispatchers.IO) {
            when (imageLoader) {
                ImageLoader.FRESCO -> Fresco.initialize(vortexApplication)
                ImageLoader.PICASSO -> {
                    Picasso.setSingletonInstance(
                        Picasso.Builder(vortexApplication)
                            .downloader(OkHttp3Downloader(vortexApplication))
                            .build()
                    )
                }
            }
        }
        return this
    }

    override suspend fun registerLeakCanaryConfiguration(): VortexConfiguration {
        withContext(Dispatchers.IO) {
            if (applicationStatus) {
                LeakSentry.config = LeakSentry.config.copy(watchFragmentViews = true)
            }
        }
        return this
    }

    override suspend fun registerApplicationState(state: Boolean): VortexConfiguration {
        withContext(Dispatchers.IO) {
            applicationStatus = state
        }
        return this
    }

    @Throws(VortexFirebaseConfigurationException::class)
    override suspend fun registerFirebaseConfiguration(moduleName: String): VortexConfiguration {
        withContext(Dispatchers.IO) {
            val firebaseConfigurationFile = File("$moduleName/google-services.json")
            if (firebaseConfigurationFile.exists()) {
                FirebaseApp.initializeApp(vortexApplication)
                FirebaseAnalytics.getInstance(vortexApplication)
            } else {
                throw VortexFirebaseConfigurationException(
                    VortexFirebaseDetailsException<FirebaseAppException>(
                        "Firebase (Google Play Services Not Exist",
                        FirebaseAppException(
                            "$moduleName/google-services.json is Not Exist At Project Files",
                            "This Exception Happend When The Google Play Services File Not Attached At Vortex App"
                        )
                    )
                )
            }
        }
        return this
    }

    override suspend fun registerStrictMode(): VortexConfiguration {
        withContext(Dispatchers.Main) {
            Handler().postAtFrontOfQueue {
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

    override suspend fun registerFabric(): VortexConfiguration {
        withContext(Dispatchers.IO) {
            Fabric.with(
                vortexApplication, Crashlytics.Builder()
                    .core(
                        CrashlyticsCore.Builder()
                            .disabled(applicationStatus)
                            .build()
                    )
                    .answers(Answers())
                    .build()
            )
        }
        return this
    }

    override suspend fun checkPlatformRequiredConfiguration(): VortexConfiguration {
        isPlatformCheckRequired = true
        return this
    }

    override fun registerVortexPrefsConfiguration(details: VortexPrefsDetails , application: Application): VortexConfiguration {
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
