package io.vanite.android.details

import io.vanite.android.models.VaniteExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:25 AM
 */

data class VaniteFirebaseDetailsException<FirebaseAppException>(
    val message: String,
    val body: FirebaseAppException
) : VaniteExceptionDetails<FirebaseAppException> {
    override fun getExceptionMessage(): String = message
    override fun getExceptionBody(): FirebaseAppException = body
}

data class FirebaseAppException(
    val exceptionType: String,
    val exceptionDetails: String
)
