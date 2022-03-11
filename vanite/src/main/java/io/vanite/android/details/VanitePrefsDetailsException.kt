package io.vanite.android.details

import io.vanite.android.models.VaniteExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:40 AM
 */

class VanitePrefsDetailsException<Reason>(
    val message: String,
    val body: Reason
) : VaniteExceptionDetails<Reason> {
    override fun getExceptionMessage(): String = message
    override fun getExceptionBody(): Reason = body
}

data class VanitePrefsDetails(
    val path: String,
    val fullReason: String
)