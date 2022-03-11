package io.vanite.android.logger

import java.lang.RuntimeException

class VortexLoggerInitException : RuntimeException() {
    override val message: String?
        get() = """
            Vortex Logging Error Intialization
            You Should Init The Logger Configuration Before Log Anything
            You Can Init The Logger From Application Class By Call
            VortexLoggerConfiguration.init(VortexLoggerDefaultOptions()) -- For Default Configuration
            VortexLoggerConfiguration.init(VortexLoggerOptions(...)) -- For Custom Configuration
        """.trimIndent()
}
