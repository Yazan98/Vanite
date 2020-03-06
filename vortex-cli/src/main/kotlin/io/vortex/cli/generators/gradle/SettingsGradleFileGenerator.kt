package io.vortex.cli.generators.gradle

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class SettingsGradleFileGenerator(private val appName: String) : VortexBaseGenerator() {

    override fun getFileType(): VortexFileType {
        return VortexFileType.XML
    }

    override fun getFileContent(): String {
        return """
            rootProject.name='${appName}'
            include ':app'
            include ':domain'
            include ':data'
        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
       return "settings"
    }
}