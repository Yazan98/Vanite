package io.vortex.spring.boot.base.errors.details

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:37 PM
 */
data class FirebaseErrorDetails(
        val reason: String,
        val missingConfiguration: List<String>
): ErrorDetails
