package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

/**
 * When You Want To Initialize The Vortex Logger Without Write The Configuration
 * You Can Use This logger Configuration
 */
class VaniteLoggerDefaultOptions : VaniteBaseOptionsInitializer {

    companion object {
        const val VORTEX_DEFAULT_TAG = "Vortex Logger"
        val VORTEX_LOGGER_PRE_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VORTEX_LOGGER_POST_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VORTEX_DEFAULT_STATE = VaniteLoggingStatus.ENABLED
        val VORTEX_DEFAULT_LEVEL = VaniteLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = VORTEX_DEFAULT_TAG
    override fun getLoggingStatus(): VaniteLoggingStatus = VORTEX_DEFAULT_STATE
    override fun getDefaultPreMode(): VaniteLoggerMode = VORTEX_LOGGER_PRE_MODE_DEFAULT
    override fun getDefaultPostMode(): VaniteLoggerMode = VORTEX_LOGGER_POST_MODE_DEFAULT
    override fun getDefaultLevel(): VaniteLoggerLevel = VORTEX_DEFAULT_LEVEL

}
