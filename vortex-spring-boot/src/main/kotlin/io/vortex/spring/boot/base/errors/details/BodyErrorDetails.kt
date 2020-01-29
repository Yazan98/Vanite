package io.vortex.spring.boot.base.errors.details

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:25 PM
 */
data class BodyErrorDetails(
        val reason: String,
        val path: String
): ErrorDetails