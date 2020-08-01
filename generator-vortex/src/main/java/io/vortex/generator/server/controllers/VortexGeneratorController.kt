package io.vortex.generator.server.controllers

import io.vortex.generator.server.controllers.body.VortexAndroidAppDetailsBody
import io.vortex.generator.server.controllers.impl.VortexGeneratorControllerImpl
import io.vortex.generator.server.exception.ExceptionUtils
import io.vortex.generator.server.exception.VortexAppError
import io.vortex.generator.server.exception.VortexValidationException
import io.vortex.generator.server.response.VortexResponse
import io.vortex.generator.server.response.VortexResponseBuilder
import io.vortex.generator.server.services.VortexGeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/generators")
open class VortexGeneratorController @Autowired constructor(
        private val service: VortexGeneratorService
) : VortexGeneratorControllerImpl {

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], path = ["/android"])
    override fun generateAndroidApp(
            @RequestBody application: VortexAndroidAppDetailsBody?,
            @RequestParam("appType") appType: String?
    ): ResponseEntity<VortexResponse> {
        if (appType == null) {
            ExceptionUtils.throwAppTypeException()
        } else if (application == null) {
            ExceptionUtils.throwRequestBodyMissingException()
        }

        service.validateAndroidAppParams(application)
        return VortexResponseBuilder.getCreatedResponse("Created!!")
    }

    @ResponseBody
    @RequestMapping(method = [RequestMethod.POST], path = ["/spring"])
    override fun generateSpringBootApp(): ResponseEntity<VortexResponse> {
        TODO("Not yet implemented")
    }

}
