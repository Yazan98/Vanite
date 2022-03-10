package io.vortex.android.models

import io.vortex.android.models.data.VortexInterceptorMode

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:59 PM
 */

interface VortexRequestDetails
data class VortexRequestDetailsProvider(
    var token: String = "",
    var language: String = "",
    var isLoggingEnabled: Boolean = true,
    var loggingTag: String = "",
    var loggingMode: VortexInterceptorMode = VortexInterceptorMode.FULL
) : VortexRequestDetails
