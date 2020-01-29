package io.vortex.spring.boot.base.errors

import com.google.api.gax.rpc.UnauthenticatedException
import io.vortex.spring.boot.base.response.VortexError
import io.vortex.spring.boot.base.response.VortexErrorResponse
import org.apache.http.MethodNotSupportedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.web.firewall.RequestRejectedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.MethodNotAllowedException
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver
import javax.servlet.http.HttpServletRequest

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 8:59 PM
 */

abstract class VortexExceptionHandler : VortexHandler<VortexErrorResponse> {

    @ExceptionHandler(VortexNotFoundException::class)
    override fun handleNotFoundException(request: HttpServletRequest, exception: VortexNotFoundException): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.NOT_FOUND.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Not Found",
                                exception.getDetails(),
                                exception.stackTrace
                        )
                ),
                HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(VortexInvalidValueException::class)
    override fun handleInvalidValueException(request: HttpServletRequest, exception: VortexInvalidValueException): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.BAD_REQUEST.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Invalid Or Missing Value",
                                exception.getDetails(),
                                exception.stackTrace
                        )
                ),
                HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(MethodNotAllowedException::class, NoSuchMethodException::class, MethodNotSupportedException::class)
    override fun handleWrongMethodException(request: HttpServletRequest, exception: Exception): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.METHOD_NOT_ALLOWED.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Invalid Or Missing Value",
                                VortexMethodError(
                                        method = request.method,
                                        reason = "This Method Not Supported At This Request"
                                ),
                                exception.stackTrace
                        )
                ),
                HttpStatus.METHOD_NOT_ALLOWED
        )
    }

    @ExceptionHandler(NullPointerException::class, KotlinNullPointerException::class)
    override fun handleNullExceptionException(request: HttpServletRequest, exception: Exception): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.NOT_FOUND.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Empty Result",
                                EmptyResultError(
                                        "No Content At This Request"
                                ),
                                exception.stackTrace
                        )
                ),
                HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(VortexAuthException::class, UnauthenticatedException::class , RequestRejectedException::class)
    override fun handleAuthRegistered(request: HttpServletRequest, exception: VortexAuthException): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.UNAUTHORIZED.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "UnAuthorized Error",
                                exception.getDetails(),
                                exception.stackTrace
                        )
                ),
                HttpStatus.UNAUTHORIZED
        )
    }

    @ExceptionHandler(VortexUserAlreadyRegisteredException::class)
    override fun handleUserAlreadyRegistered(request: HttpServletRequest, exception: VortexUserAlreadyRegisteredException): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(
                VortexErrorResponse(
                        code = HttpStatus.BAD_REQUEST.value(),
                        message = exception.message,
                        path = request.pathInfo,
                        error = VortexError(
                                "Duplicate User",
                                exception.getDetails(),
                                exception.stackTrace
                        )
                ),
                HttpStatus.BAD_REQUEST
        )
    }

}
