package io.vortex.cli.generators.gradle

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class GradleRootFileGenerator : VortexBaseGenerator() {

    companion object {
        const val gradlePlugin = "rootProject.ext.PluginsVersions.GradlePluginV"
        const val kotPlugin = "rootProject.ext.PluginsVersions.KotlinPluginV"
        const val easyLauncher = "rootProject.ext.PluginsVersions.EasyLauncherPluginV"
        const val firebasePlugin = "rootProject.ext.PluginsVersions.FirebasePluginV"
        const val ktlint = "rootProject.ext.PluginsVersions.KtlintPluginV"
        const val fabric = "rootProject.ext.PluginsVersions.FabricPluginV"
        const val navArgs = "rootProject.ext.PluginsVersions.NavigationPluginV"
        const val androidPlugin = "rootProject.ext.AndroidLibraryPlugin"
        const val kotlinPlugin = "rootProject.ext.KotlinAndroidPlugin"
        const val kotlinExtPlugin = "rootProject.ext.KotlinAndroidExPlugin"
        const val kaptPlugin = "rootProject.ext.KotlinKaptPlugin"
        const val buildToolsVersion = "rootProject.ext.BuildToolsVersion"
        const val appVersion = "rootProject.ext.ApplicationVersion"
        const val androidTest = "rootProject.ext.AndroidTest"
        const val DevBaseUrl = "DevBaseUrl"
    }

    override fun getFileType(): VortexFileType {
       return VortexFileType.GRADLE
    }

    override fun getFileContent(): String {
        return """
buildscript {

    ext.PluginsVersions = [
        "GradlePluginV"      : "4.0.0-alpha03",
        "KotlinPluginV"      : "1.3.50",
        "EasyLauncherPluginV": "1.3.1",
        "FirebasePluginV"    : "4.3.1",
        "KtlintPluginV"      : "2.1.1",
        "FabricPluginV"      : "1.28.1",
        "NavigationPluginV"  : "2.2.0-rc04"
    ]

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url 'https://maven.fabric.io/public' }
        maven { url "https://plugins.gradle.org/m2/" }
        maven { url 'https://jitpack.io' }
        maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
        maven { url "https://dl.bintray.com/yt98/Vortex" }
    }

    dependencies {
        classpath "com.android.tools.build:gradle:$${gradlePlugin}"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$${kotPlugin}"
        classpath "com.akaita.android:easylauncher:$${easyLauncher}"
        classpath "com.google.gms:google-services:$$firebasePlugin"
        classpath "org.jmailen.gradle:kotlinter-gradle:$${ktlint}"
        classpath "io.fabric.tools:gradle:$${fabric}"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$${navArgs}"
    }

}

apply from: "Libraries.gradle"
apply from: "AppDetails.gradle"

allprojects {

    repositories {
        google()
        jcenter()
        maven { url 'https://maven.fabric.io/public' }
        maven { url "https://plugins.gradle.org/m2/" }
        maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
        maven { url 'https://jitpack.io' }
        maven { url "https://dl.bintray.com/yt98/Vortex" }
    }

}

subprojects {

    if (!project.name.contains("app")) {

        apply plugin: "$${androidPlugin}"
        apply plugin: "$${kotlinPlugin}"
        apply plugin: "$${kotlinExtPlugin}"
        apply plugin: "$${kaptPlugin}"

        android {

            //signingConfigs {
            //    release {
            //        storeFile file('Key Path')
            //        storePassword 'Key Password'
            //        keyAlias = 'Key Name'
            //        keyPassword 'Key Password'
            //    }
            //
            //    debug {
            //        storeFile file('Key Path')
            //        storePassword 'Key Password'
            //        keyAlias = 'Key Name'
            //        keyPassword 'Key Password'
            //    }
            //}
    
            compileSdkVersion rootProject.ext.compileSdkV
            buildToolsVersion "$${buildToolsVersion}"
            defaultConfig {
                minSdkVersion rootProject.ext.minSdkV
                targetSdkVersion rootProject.ext.compileSdkV
                renderscriptTargetApi rootProject.ext.renderscriptTargetApi
                renderscriptSupportModeEnabled rootProject.ext.renderscriptSupportModeEnabled
                multiDexEnabled rootProject.ext.MultiDexMergeEnabled
                versionCode rootProject.ext.VersionCode
                versionName "$${appVersion}"
                testInstrumentationRunner "$${androidTest}"
                resConfigs "en", "ar"
            }
    
            buildTypes {
            
                debug {
                    minifyEnabled false
                    debuggable true
                    manifestPlaceholders = [enableCrashReporting: "false"]
                    ext.enableCrashlytics = false
                    ext.alwaysUpdateBuildId = false
                    buildConfigField "String", "BASE_URL", "\"$${DevBaseUrl}\""
            //        signingConfig signingConfigs.debug
                }
            
                release {
                    minifyEnabled true
                    debuggable false
                    ext.enableCrashlytics = true
                    manifestPlaceholders = [enableCrashReporting: "true"]
                    buildConfigField "String", "BASE_URL", "\"$${DevBaseUrl}\""
            //        signingConfig signingConfigs.release
                }
            
            }
    
            }
    
            dependencies { config ->
                defaultTestingConfiguration(config)
                def RxConfiguration = rootProject.ext.RxConfiguration
                def KotlinCoroutinesConfiguration = rootProject.ext.KotlinCoroutinesConfiguration
                
                implementation RxConfiguration.RxJava
                implementation RxConfiguration.RxAndroid
                
                implementation KotlinCoroutinesConfiguration.Coroutines
                implementation KotlinCoroutinesConfiguration.AndroidCoroutines
                
                daggerConfig(config)
                
                if (project.name.equals("domain")) {
                    lifeCycleConfiguration(config)
                }
    
            }

    }

}

gradle.projectsEvaluated {
    tasks.withType(JavaCompile) {
        options.compilerArgs << "-Xmaxerrs" << "500"
    }
}

void daggerConfig(configuration) {
    def DependenciesInjection = rootProject.ext.DependenciesInjection
    configuration.kapt DependenciesInjection.MotifCompiler
    configuration.implementation DependenciesInjection.Motif
    configuration.implementation DependenciesInjection.Dagger
    configuration.kapt DependenciesInjection.DaggerCompiler
    configuration.implementation DependenciesInjection.DaggerAndroid
    configuration.implementation DependenciesInjection.DaggerAndroidSupport
    configuration.kapt DependenciesInjection.DaggerAndroidProcessor
}

void defaultTestingConfiguration(configuration) {
    def TestingConfiguration = rootProject.ext.TestingConfiguration
    configuration.testImplementation TestingConfiguration.Junit
    configuration.androidTestImplementation TestingConfiguration.Esspresso
    configuration.androidTestImplementation TestingConfiguration.Runner
}

void lifeCycleConfiguration(configuration) {
    def LifeCycleConfiguration = rootProject.ext.LifeCycleConfiguration
    configuration.implementation LifeCycleConfiguration.LifecycleViewModel
    configuration.implementation LifeCycleConfiguration.LifecycleExtensions
    configuration.implementation LifeCycleConfiguration.LifecycleRuntime
    configuration.implementation LifeCycleConfiguration.LifecycleLiveData
    configuration.implementation LifeCycleConfiguration.LifecycleCommon
}

        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
        return "build"
    }
}