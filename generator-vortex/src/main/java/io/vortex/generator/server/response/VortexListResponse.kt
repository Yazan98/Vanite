package io.vortex.generator.server.response

data class VortexListResponse(
        var code: Int = 200,
        var message: String = "Success !!",
        var status: String = "Success",
        val data: List<Any>
)
