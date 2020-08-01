package io.vortex.generator.server.exception

import io.vortex.generator.server.response.VortexErrorResponse
import io.vortex.generator.server.response.VortexResponseBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
open class VortexExceptionHandling {

    @ExceptionHandler(MissingServletRequestParameterException::class)
    open fun handleMissingServletRequestParameterException(error: MissingServletRequestParameterException): ResponseEntity<VortexErrorResponse> {
        return VortexResponseBuilder.getErrorResponse(
                VortexValidationException(error.message, VortexAppError("Request Parameter Exception !!", error.message)),
                HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(IllegalStateException::class)
    open fun handleIllegalStateException(error: IllegalStateException): ResponseEntity<VortexErrorResponse> {
        return VortexResponseBuilder.getErrorResponse(
                VortexValidationException(error.message, VortexAppError("Request Exception !!", error.message)),
                HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    open fun handleHttpMessageNotReadableException(error: HttpMessageNotReadableException): ResponseEntity<VortexErrorResponse> {
        return VortexResponseBuilder.getErrorResponse(
                VortexValidationException(error.message, VortexAppError("Request Exception !!", error.message)),
                HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(VortexValidationException::class)
    open fun handleVortexValidationException(error: VortexValidationException): ResponseEntity<VortexErrorResponse> {
        return VortexResponseBuilder.getErrorResponse(
                VortexValidationException(error.message, VortexAppError("Request Validation Exception !!", error.message)),
                HttpStatus.BAD_REQUEST
        )
    }

}
