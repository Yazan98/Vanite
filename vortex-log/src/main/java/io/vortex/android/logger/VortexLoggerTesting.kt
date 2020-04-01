package io.vortex.android.logger

import io.vortex.android.logger.config.VortexLoggerConfiguration
import io.vortex.android.logger.config.VortexLoggerOptions
import io.vortex.android.logger.keys.VortexLoggerLevel
import io.vortex.android.logger.keys.VortexLoggerMode
import io.vortex.android.logger.keys.VortexLoggingStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VortexLoggerTesting {

    init {

        VortexLoggerConfiguration.init(
            VortexLoggerOptions(
                globalTag = "My Custom Logging Tag",
                preMode = VortexLoggerMode.EQUAL,
                defaultLevel = VortexLoggerLevel.DEBUG,
                loggingStatus = VortexLoggingStatus.ENABLED,
                postMode = VortexLoggerMode.EQUAL
            )
        )
        
        /**
         * Print pattern
         * ---------------------------------------- 100 Dash
         * Create Account Request - Your Message Here
         * ---------------------------------------- 100 Dash
         */
        VortexLog.print("Your Message Here") {
            VortexLog prePost VortexLoggerMode.DASH
            VortexLog currentTag "Crate Account Request"
            VortexLog repeat 100
        }

        /**
         * Print Error Level With Equals Pattern
         * ========================================= 50 Equal
         * Error Level -- Default Tag Or Attached Tag -- The Error Message
         * ========================================= 50 Equal
         */
        VortexLog.printLevel("The Error Message") {
            VortexLog attachLevel VortexLoggerLevel.ERROR
            VortexLog prePost VortexLoggerMode.EQUAL
            VortexLog currentTag "Crate Account Request - OnError"
            VortexLog repeat 50
        }
    }

}
