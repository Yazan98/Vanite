package io.vortex.cli.generators.gradle

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class GradleAppInfoFileGenerator(private val packageName: String) : VortexBaseGenerator() {
    override fun getFileType(): VortexFileType {
        return VortexFileType.GRADLE
    }

    override fun getFileContent(): String {
        return """
            ext {

                // Plugins
                AndroidPlugin = "com.android.application"
                KotlinAndroidPlugin = "kotlin-android"
                KotlinAndroidExPlugin = "kotlin-android-extensions"
                KotlinKaptPlugin = "kotlin-kapt"
                AndroidLibraryPlugin = "com.android.library"
                FirebasePlugin = "com.google.gms.google-services"
                FabricPlugin = "io.fabric"
                navigationPlugin = "androidx.navigation.safeargs"
                EasyLauncherPlugin = "com.akaita.android.easylauncher"

                //Android Details
                compileSdkV = 29
                BuildToolsVersion = "29.0.0"
                HttpLegacyEnabled = "org.apache.http.legacy"
                applicationPackage = "${packageName}"
                AndroidRunnerArgument = "listener"
                KotlinSource = "src/main/kotlin"
                EasyLauncherForground = "@mipmap/ic_launcher_foreground"
                LeakCanaryListener = "com.squareup.leakcanary.FailTestOnLeakRunListener"
                minSdkV = 25
                MultiDexMergeEnabled = true
                ApplicationVersion = "1.0"
                VersionCode = 1
                renderscriptTargetApi = 26
                renderscriptSupportModeEnabled = true
                AndroidTest = "androidx.test.runner.AndroidJUnitRunner"
                ApplicationBuildType = "Testing"
                ProguardFile = "proguard-android-optimize.txt"
                Proguard = "proguard-rules.pro"
            }

        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
        return "AppDetails"
    }
}