package io.vortex.spring.boot.base.errors

import io.vortex.spring.boot.base.errors.details.FirebaseErrorDetails
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:35 PM
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class VortexFirebaseException(override val message: String?, details: FirebaseErrorDetails) : VortexException(message , details) {
    init {
        logException(this)
    }
}
