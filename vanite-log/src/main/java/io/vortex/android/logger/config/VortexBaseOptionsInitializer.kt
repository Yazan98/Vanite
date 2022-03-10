package io.vortex.android.logger.config

import io.vortex.android.logger.keys.VortexLoggerLevel
import io.vortex.android.logger.keys.VortexLoggerMode
import io.vortex.android.logger.keys.VortexLoggingStatus

interface VortexBaseOptionsInitializer {

    fun getGlobalTag(): String

    fun getLoggingStatus(): VortexLoggingStatus

    fun getDefaultPreMode(): VortexLoggerMode

    fun getDefaultPostMode(): VortexLoggerMode

    fun getDefaultLevel(): VortexLoggerLevel

}
