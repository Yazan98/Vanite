package io.vortex.generator.server.controllers.impl

import io.vortex.generator.server.controllers.body.VortexAndroidAppDetailsBody
import io.vortex.generator.server.response.VortexResponse
import org.springframework.http.ResponseEntity

interface VortexGeneratorControllerImpl {

    fun generateAndroidApp(application: VortexAndroidAppDetailsBody?, appType: String?): ResponseEntity<VortexResponse>

    fun generateSpringBootApp(): ResponseEntity<VortexResponse>

}
