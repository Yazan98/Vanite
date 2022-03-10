package io.vortex.android.models

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:48 PM
 */

@Deprecated("Not Used Anymore, Should be Declared in Retrofit Instance Interceptors")
data class VortexAuth(
    var username: String = "",
    var password: String = ""
)
