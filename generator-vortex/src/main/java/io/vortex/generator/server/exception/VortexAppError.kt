package io.vortex.generator.server.exception

data class VortexAppError(
        var message: String? = "Something Error",
        var reason: String? = "Something Error With Input Details"
)