package io.vortex.generator.server.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class VortexMissingValueException(
        override val message: String?,
        private val appError: VortexAppError
) : VortexException("App Details Missing Value With Details : $message", appError)
