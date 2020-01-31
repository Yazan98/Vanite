package io.vortex.spring.boot.base.errors

import com.google.api.gax.rpc.UnauthenticatedException
import io.vortex.spring.boot.base.response.VortexCustomErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.MethodNotAllowedException
import javax.servlet.http.HttpServletRequest

abstract class VortexCommonExceptionHandler {

    @ExceptionHandler(Throwable::class)
    fun handleNotFoundException(request: HttpServletRequest, exception: Throwable): ResponseEntity<VortexCustomErrorResponse> {
        var errorCode = HttpStatus.INTERNAL_SERVER_ERROR
        when (exception) {
            is VortexNotFoundException -> errorCode = HttpStatus.NOT_FOUND
            is VortexInvalidValueException -> errorCode = HttpStatus.BAD_GATEWAY
            is NullPointerException -> errorCode = HttpStatus.NOT_FOUND
            is MethodNotAllowedException -> errorCode = HttpStatus.METHOD_NOT_ALLOWED
            is UnauthenticatedException -> errorCode = HttpStatus.UNAUTHORIZED
        }
        return ResponseEntity(
                VortexCustomErrorResponse(
                        code = errorCode.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        stacktrace = exception.stackTrace,
                        status = "Failed"
                ),
                HttpStatus.NOT_FOUND
        )
    }

}