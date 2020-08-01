package io.vortex.generator.server.controllers

import io.vortex.generator.server.controllers.impl.VortexConfigurationControllerImpl
import io.vortex.generator.server.controllers.impl.VortexGeneratorControllerImpl
import io.vortex.generator.server.models.VortexAndroidApplication
import io.vortex.generator.server.response.VortexResponse
import io.vortex.generator.server.response.VortexResponseBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/configuration")
open class VortexConfigurationController: VortexConfigurationControllerImpl {

    @RequestMapping(method = [RequestMethod.GET], path = ["/android-app"])
    override fun getAndroidAppConfiguration(): ResponseEntity<VortexResponse> {
        return VortexResponseBuilder.getSuccessResponse(VortexAndroidApplication())
    }


}
