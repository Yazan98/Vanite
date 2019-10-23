package io.vortex.android.details

import io.vortex.android.models.VortexExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:25 AM
 */

data class VortexFirebaseDetailsException<FirebaseAppException>(
    val message: String,
    val body: FirebaseAppException
) : VortexExceptionDetails<FirebaseAppException> {
    override fun getExceptionMessage(): String = message
    override fun getExceptionBody(): FirebaseAppException = body
}

data class FirebaseAppException(
    val exceptionType: String,
    val exceptionDetails: String
)
