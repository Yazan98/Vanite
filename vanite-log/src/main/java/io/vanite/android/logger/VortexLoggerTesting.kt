package io.vanite.android.logger

import io.vanite.android.logger.config.VortexLoggerConfiguration
import io.vanite.android.logger.config.VortexLoggerOptions
import io.vanite.android.logger.keys.VortexLoggerLevel
import io.vanite.android.logger.keys.VortexLoggerMode
import io.vanite.android.logger.keys.VortexLoggingStatus

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
