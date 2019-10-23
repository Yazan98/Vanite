package io.vortex.android.details

import io.vortex.android.models.VortexExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:40 AM
 */

class VortexPrefsDetailsException<Reason>(
    val message: String,
    val body: Reason
) : VortexExceptionDetails<Reason> {
    override fun getExceptionMessage(): String = message
    override fun getExceptionBody(): Reason = body
}

data class VortexPrefsDetails(
    val path: String,
    val fullReason: String
)