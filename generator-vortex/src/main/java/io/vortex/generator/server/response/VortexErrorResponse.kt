package io.vortex.generator.server.response

import io.vortex.generator.server.exception.VortexAppError

data class VortexErrorResponse(
        var code: Int = 200,
        var message: String = "Success !!",
        var status: String = "Success",
        var error: String = "",
        var errorBody: VortexAppError,
        var stacktrace: Array<StackTraceElement>? = null
)
