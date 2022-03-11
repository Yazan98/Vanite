package io.vanite.android.logger.config

import io.vanite.android.logger.VaniteLoggerInitException

object VaniteLoggerConfiguration {

    private lateinit var loggerConfiguration: VaniteBaseOptionsInitializer
    fun init(options : VaniteBaseOptionsInitializer) {
        loggerConfiguration = options
    }

    @Throws(VaniteLoggerInitException::class)
    fun getLoggingConfiguration(): VaniteBaseOptionsInitializer {
        return if (::loggerConfiguration.isInitialized) {
            loggerConfiguration
        } else {
            throw VaniteLoggerInitException()
        }
    }

}
