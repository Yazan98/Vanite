package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

interface VaniteBaseOptionsInitializer {

    fun getGlobalTag(): String

    fun getLoggingStatus(): VaniteLoggingStatus

    fun getDefaultPreMode(): VaniteLoggerMode

    fun getDefaultPostMode(): VaniteLoggerMode

    fun getDefaultLevel(): VaniteLoggerLevel

}
