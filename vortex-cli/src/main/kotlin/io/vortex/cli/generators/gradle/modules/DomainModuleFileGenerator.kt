package io.vortex.cli.generators.gradle.modules

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class DomainModuleFileGenerator: VortexBaseGenerator() {
    override fun getFileType(): VortexFileType {
        return VortexFileType.GRADLE
    }

    override fun getFileContent(): String {
        return """
            dependencies { configuration ->
                implementation project(":data")
                lifeCycleConfiguration(configuration)
                vortexConfiguration(configuration)
            }

            private void vortexConfiguration(configuration) {
                def VortexConfiguration = rootProject.ext.VortexConfiguration
                configuration.implementation VortexConfiguration.VortexCore
                configuration.implementation VortexConfiguration.VortexLocal
                configuration.implementation VortexConfiguration.VortexData
                configuration.implementation VortexConfiguration.VortexPrefs
            }

        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
        return "domain/build"
    }
}