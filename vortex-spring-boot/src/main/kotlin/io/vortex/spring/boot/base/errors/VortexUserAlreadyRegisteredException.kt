package io.vortex.spring.boot.base.errors

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:15 PM
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
class VortexUserAlreadyRegisteredException(override val message: String?, details: ErrorDetails) : VortexException(message , details) {
    init {
        logException(this)
    }
}
