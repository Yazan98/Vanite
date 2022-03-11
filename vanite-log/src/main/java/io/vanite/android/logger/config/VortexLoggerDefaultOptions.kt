package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VortexLoggerLevel
import io.vanite.android.logger.keys.VortexLoggerMode
import io.vanite.android.logger.keys.VortexLoggingStatus

/**
 * When You Want To Initialize The Vortex Logger Without Write The Configuration
 * You Can Use This logger Configuration
 */
class VortexLoggerDefaultOptions : VortexBaseOptionsInitializer {

    companion object {
        const val VORTEX_DEFAULT_TAG = "Vortex Logger"
        val VORTEX_LOGGER_PRE_MODE_DEFAULT = VortexLoggerMode.DASH
        val VORTEX_LOGGER_POST_MODE_DEFAULT = VortexLoggerMode.DASH
        val VORTEX_DEFAULT_STATE = VortexLoggingStatus.ENABLED
        val VORTEX_DEFAULT_LEVEL = VortexLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = VORTEX_DEFAULT_TAG
    override fun getLoggingStatus(): VortexLoggingStatus = VORTEX_DEFAULT_STATE
    override fun getDefaultPreMode(): VortexLoggerMode = VORTEX_LOGGER_PRE_MODE_DEFAULT
    override fun getDefaultPostMode(): VortexLoggerMode = VORTEX_LOGGER_POST_MODE_DEFAULT
    override fun getDefaultLevel(): VortexLoggerLevel = VORTEX_DEFAULT_LEVEL

}
