package io.vortex.spring.boot.base.models

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:49 PM
 */

data class VortexApplicationInfo(
        var name: String = "",
        var address: String = "localhost",
        var port: Int = 8090
)
