package io.vortex.generator.server.response

import io.vortex.generator.server.exception.VortexException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

interface ResponseBuilderImpl {

    fun getSuccessResponse(body: Any?): ResponseEntity<VortexResponse>

    fun getCreatedResponse(body: Any?): ResponseEntity<VortexResponse>

    fun getErrorResponse(error: VortexException, status: HttpStatus): ResponseEntity<VortexErrorResponse>

    fun getListResponse(data: List<Any>): ResponseEntity<VortexListResponse>

}
