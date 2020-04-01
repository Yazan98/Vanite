package io.vortex.android.logger

import io.vortex.android.logger.keys.VortexLoggerMode

class VortexLoggerTesting {

    init {
        VortexLog.print("Your Message Here") {
            VortexLog prePost VortexLoggerMode.DASH
            VortexLog repeat 100
        }
    }

}
