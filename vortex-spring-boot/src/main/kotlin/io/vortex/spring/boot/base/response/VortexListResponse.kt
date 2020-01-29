package io.vortex.spring.boot.base.response

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:12 PM
 */

data class VortexListResponse(
        val code: Int,
        var message: String,
        var status: String = "Success",
        val data: List<Any>,
        var size: Int = data.size
) : VortexResponse
