package io.vortex.spring.boot.base.errors

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:06 PM
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class VortexInternalServerException(override val message: String?, details: ErrorDetails) : VortexException(message , details) {
    init {
        logException(this)
    }

    data class DataNotDeletedDetails(val id: Any? , val reason: String?): ErrorDetails
}
