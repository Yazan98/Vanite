package io.vortex.android.models

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:59 PM
 */

interface VortexRequestDetails
data class VortexRequestDetailsProvider(
    var token: String = "",
    var language: String = ""
) : VortexRequestDetails