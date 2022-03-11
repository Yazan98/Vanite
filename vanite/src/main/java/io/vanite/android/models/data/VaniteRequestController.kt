package io.vanite.android.models.data

/**
 * Created By : Yazan Tarifi
 * Date : 12/25/2019
 * Time : 12:35 AM
 */

data class VaniteRequestController(
    var loggingMode: VaniteInterceptorMode,
    var loggingTag: String? = "Vanite Request Logger ",
    var isLoggingEnabled: Boolean = true
)
