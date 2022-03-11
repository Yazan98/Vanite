package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VortexLoggerLevel
import io.vanite.android.logger.keys.VortexLoggerMode
import io.vanite.android.logger.keys.VortexLoggingStatus

interface VortexBaseOptionsInitializer {

    fun getGlobalTag(): String

    fun getLoggingStatus(): VortexLoggingStatus

    fun getDefaultPreMode(): VortexLoggerMode

    fun getDefaultPostMode(): VortexLoggerMode

    fun getDefaultLevel(): VortexLoggerLevel

}
