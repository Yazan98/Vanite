package io.vortex.android.models.data

/**
 * Created By : Yazan Tarifi
 * Date : 12/25/2019
 * Time : 12:35 AM
 */

data class VortexRequestController(
    var loggingMode: VortexInterceptorMode,
    var loggingTag: String? = "Vortex Request Logger ",
    var isLoggingEnabled: Boolean = true
)
