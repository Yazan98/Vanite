package io.vortex.cli.generators.gradle.modules

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class DataModuleFileGenerator: VortexBaseGenerator() {
    override fun getFileType(): VortexFileType {
        return VortexFileType.GRADLE
    }

    override fun getFileContent(): String {
        return """
            dependencies { configuration ->
                implementation fileTree(dir: 'libs', include: ['*.jar'])
                rxJavaConfiguration(configuration)
                retrofitConfiguration(configuration)
                vortexConfiguration(configuration)
            }

            private void rxJavaConfiguration(configuration) {
                def RxConfiguration = rootProject.ext.RxConfiguration
                configuration.implementation RxConfiguration.RxJava
                configuration.implementation RxConfiguration.RxAndroid
            }

            private void retrofitConfiguration(configuration) {
                def DataConfiguration = rootProject.ext.DataConfiguration
                configuration.implementation DataConfiguration.Retrofit
                configuration.implementation DataConfiguration.RetrofitRxJavaAdapter
                configuration.implementation DataConfiguration.RetrofitIntercenptor
                configuration.implementation DataConfiguration.retrofitGsonConverter
            }

            private void vortexConfiguration(configuration) {
                def VortexConfiguration = rootProject.ext.VortexConfiguration
                configuration.implementation VortexConfiguration.VortexCore
                configuration.implementation VortexConfiguration.VortexData
                configuration.implementation VortexConfiguration.VortexPrefs
            }
        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
        return "data/build"
    }
}