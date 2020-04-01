package io.vortex.android.logger.config

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object VortexLoggerConfiguration {

    private lateinit var loggerConfiguration: VortexBaseOptionsInitializer

    suspend fun init(options : VortexBaseOptionsInitializer) {
        withContext(Dispatchers.IO) {
            this@VortexLoggerConfiguration.loggerConfiguration = options
        }
    }

    fun getLoggingConfiguration(): VortexBaseOptionsInitializer {
        return loggerConfiguration
    }

}
