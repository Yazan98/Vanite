package io.vortex.spring.boot.base.errors

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 8:58 PM
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
class VortexNotFoundException(override val message: String?, details: ErrorDetails) : VortexException(message , details) {
    init {
        logException(this)
    }
}

data class EmptyErrorDetails(
        val id: Any?,
        val reason: String?
): ErrorDetails