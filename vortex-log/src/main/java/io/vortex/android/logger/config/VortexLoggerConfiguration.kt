package io.vortex.android.logger.config

import io.vortex.android.logger.VortexLoggerInitException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object VortexLoggerConfiguration {

    private lateinit var loggerConfiguration: VortexBaseOptionsInitializer
    suspend fun init(options : VortexBaseOptionsInitializer) {
        withContext(Dispatchers.IO) {
            this@VortexLoggerConfiguration.loggerConfiguration = options
        }
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
