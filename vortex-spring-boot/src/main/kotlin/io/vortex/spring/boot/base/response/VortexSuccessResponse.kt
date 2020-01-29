package io.vortex.spring.boot.base.response

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:04 PM
 */
data class VortexSuccessResponse(
        val code: Int,
        var message: String,
        var status: String = "Success",
        val data: Any?
) : VortexResponse
