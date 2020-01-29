package io.vortex.spring.boot.base.errors

import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletRequest

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:11 PM
 */

interface VortexHandler<R> {

    fun handleNotFoundException(request: HttpServletRequest, exception: VortexNotFoundException): ResponseEntity<R>

    fun handleInvalidValueException(request: HttpServletRequest, exception: VortexInvalidValueException): ResponseEntity<R>

    fun handleWrongMethodException(request: HttpServletRequest, exception: Exception): ResponseEntity<R>

    fun handleNullExceptionException(request: HttpServletRequest, exception: Exception): ResponseEntity<R>

    fun handleUserAlreadyRegistered(request: HttpServletRequest, exception: VortexUserAlreadyRegisteredException): ResponseEntity<R>

    fun handleAuthRegistered(request: HttpServletRequest, exception: VortexAuthException): ResponseEntity<R>

}
