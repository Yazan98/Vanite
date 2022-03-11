package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

/**
 * You Can Use This Configuration When You Need To Refactor The Default Logging Configuration
 */
data class VaniteLoggerOptions(
    private var globalTag: String = VANITE_DEFAULT_TAG,
    private var loggingStatus: VaniteLoggingStatus = VANITE_DEFAULT_STATE,
    private var preMode: VaniteLoggerMode = VANITE_LOGGER_PRE_MODE_DEFAULT,
    private var postMode: VaniteLoggerMode = VANITE_LOGGER_POST_MODE_DEFAULT,
    private var defaultLevel: VaniteLoggerLevel = VANITE_DEFAULT_LEVEL
) : VaniteBaseOptionsInitializer {

    companion object {
        const val VANITE_DEFAULT_TAG = "Vanite Logger"
        val VANITE_LOGGER_PRE_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VANITE_LOGGER_POST_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VANITE_DEFAULT_STATE = VaniteLoggingStatus.ENABLED
        val VANITE_DEFAULT_LEVEL = VaniteLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = globalTag
    override fun getLoggingStatus(): VaniteLoggingStatus = loggingStatus
    override fun getDefaultPreMode(): VaniteLoggerMode = preMode
    override fun getDefaultPostMode(): VaniteLoggerMode = postMode
    override fun getDefaultLevel(): VaniteLoggerLevel = defaultLevel

}
