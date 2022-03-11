package io.vanite.android.utils

import android.app.Application
import io.vanite.android.errors.VaniteFirebaseConfigurationException
import io.vanite.android.models.VanitePrefsDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:52 PM
 */

interface VaniteConfigurationImpl<L, I> {

    fun registerApplicationClass(app: Application): VaniteConfiguration

    suspend fun registerApplicationLogger(logger: L): VaniteConfiguration

    suspend fun registerImageLoader(imageLoader: I): VaniteConfiguration

    suspend fun registerApplicationState(state: Boolean): VaniteConfiguration

    @Throws(VaniteFirebaseConfigurationException::class)
    suspend fun registerFirebaseConfiguration(moduleName: String): VaniteConfiguration

    suspend fun registerStrictMode(): VaniteConfiguration

    suspend fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): VaniteConfiguration

    suspend fun registerCompatVector(): VaniteConfiguration

    suspend fun registerFabric(): VaniteConfiguration

    suspend fun checkPlatformRequiredConfiguration(): VaniteConfiguration

    fun registerVanitePrefsConfiguration(details: VanitePrefsDetails, application: Application): VaniteConfiguration

    suspend fun registerUserStoryConfiguration(): VaniteConfiguration

    suspend fun registerVanitePermissionsSettings(): VaniteConfiguration

}
