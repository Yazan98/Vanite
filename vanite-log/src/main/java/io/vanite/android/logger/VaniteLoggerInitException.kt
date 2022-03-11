package io.vanite.android.logger

import java.lang.RuntimeException

class VaniteLoggerInitException : RuntimeException() {
    override val message: String?
        get() = """
            Vanite Logging Error Intialization
            You Should Init The Logger Configuration Before Log Anything
            You Can Init The Logger From Application Class By Call
            VaniteLoggerConfiguration.init(VaniteLoggerDefaultOptions()) -- For Default Configuration
            VaniteLoggerConfiguration.init(VaniteLoggerOptions(...)) -- For Custom Configuration
        """.trimIndent()
}
