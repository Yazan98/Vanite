package io.vortex.generator.server.controllers.impl

import io.vortex.generator.server.response.VortexResponse
import org.springframework.http.ResponseEntity

interface VortexConfigurationControllerImpl {

    fun getAndroidAppConfiguration(): ResponseEntity<VortexResponse>

}