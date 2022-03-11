package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

/**
 * When You Want To Initialize The Vanite Logger Without Write The Configuration
 * You Can Use This logger Configuration
 */
class VaniteLoggerDefaultOptions : VaniteBaseOptionsInitializer {

    companion object {
        const val VANITE_DEFAULT_TAG = "Vanite Logger"
        val VANITE_LOGGER_PRE_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VANITE_LOGGER_POST_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VANITE_DEFAULT_STATE = VaniteLoggingStatus.ENABLED
        val VANITE_DEFAULT_LEVEL = VaniteLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = VANITE_DEFAULT_TAG
    override fun getLoggingStatus(): VaniteLoggingStatus = VANITE_DEFAULT_STATE
    override fun getDefaultPreMode(): VaniteLoggerMode = VANITE_LOGGER_PRE_MODE_DEFAULT
    override fun getDefaultPostMode(): VaniteLoggerMode = VANITE_LOGGER_POST_MODE_DEFAULT
    override fun getDefaultLevel(): VaniteLoggerLevel = VANITE_DEFAULT_LEVEL

}
