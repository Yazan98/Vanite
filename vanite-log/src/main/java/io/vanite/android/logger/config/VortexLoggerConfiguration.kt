package io.vanite.android.logger.config

import io.vanite.android.logger.VortexLoggerInitException

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
