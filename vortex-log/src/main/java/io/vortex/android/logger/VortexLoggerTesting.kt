package io.vortex.android.logger

import io.vortex.android.logger.keys.VortexLoggerLevel
import io.vortex.android.logger.keys.VortexLoggerMode

class VortexLoggerTesting {

    init {
        VortexLog.print("Your Message Here") {
            VortexLog prePost VortexLoggerMode.DASH
            VortexLog currentTag "Crate Account Request"
            VortexLog repeat 100
        }

        VortexLog.printLevel("The Error Message") {
            VortexLog attachLevel VortexLoggerLevel.ERROR
            VortexLog prePost VortexLoggerMode.EQUAL
            VortexLog repeat 50
        }
    }

}
