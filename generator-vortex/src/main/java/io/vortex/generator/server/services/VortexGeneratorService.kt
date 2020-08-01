package io.vortex.generator.server.services

import io.vortex.generator.server.controllers.body.VortexAndroidAppDetailsBody
import io.vortex.generator.server.services.impl.VortexGeneratorImpl
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class VortexGeneratorService : VortexGeneratorImpl {

    override fun validateAndroidAppParams(app: VortexAndroidAppDetailsBody?) {
        TODO("Not yet implemented")
    }

    override fun validateSpringAppParams() {
        TODO("Not yet implemented")
    }

    override fun startAndroidGenerator() {
        TODO("Not yet implemented")
    }

    override fun startSpringGenerator() {
        TODO("Not yet implemented")
    }

}