package io.vortex.generator.server.response

data class VortexResponse(
        var code: Int = 200,
        var message: String = "Success !!",
        var status: String = "Success",
        var data: Any? = null
)
