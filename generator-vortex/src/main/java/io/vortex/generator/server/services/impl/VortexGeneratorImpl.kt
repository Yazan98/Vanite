package io.vortex.generator.server.services.impl

import io.vortex.generator.server.controllers.body.VortexAndroidAppDetailsBody

interface VortexGeneratorImpl {

    fun validateAndroidAppParams(app: VortexAndroidAppDetailsBody?)

    fun validateSpringAppParams()

    fun startAndroidGenerator()

    fun startSpringGenerator()

}
