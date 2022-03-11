package io.vanite.android.models

import io.vanite.android.models.data.VaniteInterceptorMode

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:59 PM
 */

interface VaniteRequestDetails

data class VaniteRequestDetailsProvider(
    var token: String = "",
    var language: String = "",
    var isLoggingEnabled: Boolean = true,
    var loggingTag: String = "",
    var loggingMode: VaniteInterceptorMode = VaniteInterceptorMode.FULL
) : VaniteRequestDetails
