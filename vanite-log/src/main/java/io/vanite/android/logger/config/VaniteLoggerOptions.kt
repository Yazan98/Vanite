package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

/**
 * You Can Use This Configuration When You Need To Refactor The Default Logging Configuration
 */
data class VaniteLoggerOptions(
    private var globalTag: String = VORTEX_DEFAULT_TAG,
    private var loggingStatus: VaniteLoggingStatus = VORTEX_DEFAULT_STATE,
    private var preMode: VaniteLoggerMode = VORTEX_LOGGER_PRE_MODE_DEFAULT,
    private var postMode: VaniteLoggerMode = VORTEX_LOGGER_POST_MODE_DEFAULT,
    private var defaultLevel: VaniteLoggerLevel = VORTEX_DEFAULT_LEVEL
) : VaniteBaseOptionsInitializer {

    companion object {
        const val VORTEX_DEFAULT_TAG = "Vortex Logger"
        val VORTEX_LOGGER_PRE_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VORTEX_LOGGER_POST_MODE_DEFAULT = VaniteLoggerMode.DASH
        val VORTEX_DEFAULT_STATE = VaniteLoggingStatus.ENABLED
        val VORTEX_DEFAULT_LEVEL = VaniteLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = globalTag
    override fun getLoggingStatus(): VaniteLoggingStatus = loggingStatus
    override fun getDefaultPreMode(): VaniteLoggerMode = preMode
    override fun getDefaultPostMode(): VaniteLoggerMode = postMode
    override fun getDefaultLevel(): VaniteLoggerLevel = defaultLevel

}
