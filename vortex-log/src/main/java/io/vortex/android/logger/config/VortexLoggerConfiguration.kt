package io.vortex.android.logger.config

import io.vortex.android.logger.VortexLoggerInitException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object VortexLoggerConfiguration {

    private lateinit var loggerConfiguration: VortexBaseOptionsInitializer
    fun init(options : VortexBaseOptionsInitializer) {
        loggerConfiguration = options
    }

    @Throws(VortexLoggerInitException::class)
    fun getLoggingConfiguration(): VortexBaseOptionsInitializer {
        return if (::loggerConfiguration.isInitialized) {
            loggerConfiguration
        } else {
            throw VortexLoggerInitException()
        }
    }

}
