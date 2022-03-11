package io.vanite.android.logger.config

import io.vanite.android.logger.keys.VortexLoggerLevel
import io.vanite.android.logger.keys.VortexLoggerMode
import io.vanite.android.logger.keys.VortexLoggingStatus

/**
 * You Can Use This Configuration When You Need To Refactor The Default Logging Configuration
 */
data class VortexLoggerOptions(
    private var globalTag: String = VORTEX_DEFAULT_TAG,
    private var loggingStatus: VortexLoggingStatus = VORTEX_DEFAULT_STATE,
    private var preMode: VortexLoggerMode = VORTEX_LOGGER_PRE_MODE_DEFAULT,
    private var postMode: VortexLoggerMode = VORTEX_LOGGER_POST_MODE_DEFAULT,
    private var defaultLevel: VortexLoggerLevel = VORTEX_DEFAULT_LEVEL
) : VortexBaseOptionsInitializer {

    companion object {
        const val VORTEX_DEFAULT_TAG = "Vortex Logger"
        val VORTEX_LOGGER_PRE_MODE_DEFAULT = VortexLoggerMode.DASH
        val VORTEX_LOGGER_POST_MODE_DEFAULT = VortexLoggerMode.DASH
        val VORTEX_DEFAULT_STATE = VortexLoggingStatus.ENABLED
        val VORTEX_DEFAULT_LEVEL = VortexLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = globalTag
    override fun getLoggingStatus(): VortexLoggingStatus = loggingStatus
    override fun getDefaultPreMode(): VortexLoggerMode = preMode
    override fun getDefaultPostMode(): VortexLoggerMode = postMode
    override fun getDefaultLevel(): VortexLoggerLevel = defaultLevel

}
