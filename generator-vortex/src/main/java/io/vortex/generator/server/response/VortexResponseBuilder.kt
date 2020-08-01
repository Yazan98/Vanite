package io.vortex.generator.server.response

import io.vortex.generator.server.exception.VortexException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object VortexResponseBuilder : ResponseBuilderImpl {

    override fun getSuccessResponse(body: Any?): ResponseEntity<VortexResponse> {
        return ResponseEntity.ok(VortexResponse(
                code = HttpStatus.OK.value(),
                data = body,
                message = "Success !!",
                status = "Success"
        ))
    }

    override fun getCreatedResponse(body: Any?): ResponseEntity<VortexResponse> {
        return ResponseEntity.ok(VortexResponse(
                code = HttpStatus.CREATED.value(),
                data = body,
                message = "Created !!",
                status = "Success"
        ))
    }

    override fun getErrorResponse(error: VortexException, status: HttpStatus): ResponseEntity<VortexErrorResponse> {
        return ResponseEntity(VortexErrorResponse(
                code = status.value(),
                error = error.message.toString(),
                stacktrace = error.stackTrace,
                message = "Failed With Reason !!",
                status = "Failed",
                errorBody = error.getExceptionError()
        ), status)
    }

    override fun getListResponse(data: List<Any>): ResponseEntity<VortexListResponse> {
        return ResponseEntity.ok(VortexListResponse(
                code = HttpStatus.CREATED.value(),
                data = data,
                message = "Created !!",
                status = "Success"
        ))
    }

}
