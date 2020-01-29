package io.vortex.spring.boot.base.models

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 11/6/2019
 * Time : 4:25 AM
 */
data class VortexTokenDetails(
        val secreteKey: String,
        val validityInMilliseconds: Long
)

data class TokenInformation(
        val key: String,
        val value: String
)

data class TokenErrorDetails(
        val reason: String
): ErrorDetails