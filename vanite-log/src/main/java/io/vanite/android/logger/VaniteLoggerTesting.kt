package io.vanite.android.logger

import io.vanite.android.logger.config.VaniteLoggerConfiguration
import io.vanite.android.logger.config.VaniteLoggerOptions
import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

class VaniteLoggerTesting {

    init {

        VaniteLoggerConfiguration.init(
            VaniteLoggerOptions(
                globalTag = "My Custom Logging Tag",
                preMode = VaniteLoggerMode.EQUAL,
                defaultLevel = VaniteLoggerLevel.DEBUG,
                loggingStatus = VaniteLoggingStatus.ENABLED,
                postMode = VaniteLoggerMode.EQUAL
            )
        )

        /**
         * Print pattern
         * ---------------------------------------- 100 Dash
         * Create Account Request - Your Message Here
         * ---------------------------------------- 100 Dash
         */
        VaniteLog.print("Your Message Here") {
            VaniteLog prePost VaniteLoggerMode.DASH
            VaniteLog currentTag "Crate Account Request"
            VaniteLog repeat 100
        }

        /**
         * Print Error Level With Equals Pattern
         * ========================================= 50 Equal
         * Error Level -- Default Tag Or Attached Tag -- The Error Message
         * ========================================= 50 Equal
         */
        VaniteLog.printLevel("The Error Message") {
            VaniteLog attachLevel VaniteLoggerLevel.ERROR
            VaniteLog prePost VaniteLoggerMode.EQUAL
            VaniteLog currentTag "Crate Account Request - OnError"
            VaniteLog repeat 50
        }
    }

}
