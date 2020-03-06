package io.vortex.cli.generators.gradle.modules

import io.vortex.cli.generators.VortexBaseGenerator
import io.vortex.cli.generators.VortexFileType

class AppModuleFileGenerator : VortexBaseGenerator() {

    companion object {
        const val KotlinPlugin = "rootProject.ext.KotlinAndroidPlugin"
        const val AndroidPlugin = "rootProject.ext.AndroidPlugin"
        const val KotlinExt = "rootProject.ext.KotlinAndroidExPlugin"
        const val EasyLauncher = "rootProject.ext.EasyLauncherPlugin"
        const val KaptPlugin = "rootProject.ext.KotlinKaptPlugin"
        const val buildTools = "rootProject.ext.BuildToolsVersion"
        const val httpEnabled = "rootProject.ext.HttpLegacyEnabled"
        const val appPackage = "rootProject.ext.applicationPackage"
        const val AppVersion = "rootProject.ext.ApplicationVersion"
        const val AndroidTest = "rootProject.ext.AndroidTest"
        const val args = "rootProject.ext.AndroidRunnerArgument"
        const val laek = "rootProject.ext.LeakCanaryListener"
        const val DevBaseUrl = "DevBaseUrl"
        const val source = "rootProject.ext.KotlinSource"
        const val ReleaseBaseUrl = "ReleaseBaseUrl"
        const val forground = "rootProject.ext.EasyLauncherForground"
        const val profileName = "profileName"
        const val appName = "appName"
        const val versionName = "versionName"
        const val buildType = "rootProject.ext.ApplicationBuildType"
    }

    override fun getFileType(): VortexFileType {
        return VortexFileType.GRADLE
    }

    override fun getFileContent(): String {
        return """
apply plugin: "${AndroidPlugin}"
apply plugin: "${KotlinPlugin}"
apply plugin: "${KotlinExt}"
apply plugin: "${EasyLauncher}"
apply plugin: "${KaptPlugin}"
apply plugin: "androidx.navigation.safeargs.kotlin"


android {

    compileSdkVersion rootProject.ext.compileSdkV
    buildToolsVersion "${buildTools}"
    useLibrary "${httpEnabled}"

    defaultConfig {
        applicationId "${appPackage}"
        minSdkVersion rootProject.ext.minSdkV
        targetSdkVersion rootProject.ext.compileSdkV
        renderscriptTargetApi rootProject.ext.renderscriptTargetApi
        renderscriptSupportModeEnabled rootProject.ext.renderscriptSupportModeEnabled
        multiDexEnabled rootProject.ext.MultiDexMergeEnabled
        versionCode rootProject.ext.VersionCode
        versionName "${AppVersion}"
        testInstrumentationRunner "${AndroidTest}"
        resConfigs "en", "ar"
        testInstrumentationRunnerArgument "${args}", "${laek}"
        javaCompileOptions {
            annotationProcessorOptions {
                includeCompileClasspath true
            }
        }

        manifestPlaceholders = [
            enableCrashReporting: "false",
            CrashReportingApiKey: "ApiKeyHere",
            GoogleMapsApiKey    : "GoogleMapsApiKey"
        ]
    }


    lintOptions {
        abortOnError false
    }

//    signingConfigs {
//        release {
            //storeFile file('Key Path')
            //storePassword 'Key Password'
            //keyAlias = 'Key Name'
            //keyPassword 'Key Password'
//        }
//
//        debug {
//storeFile file('Key Path')
//storePassword 'Key Password'
//keyAlias = 'Key Name'
//keyPassword 'Key Password'
//        }
//    }

    buildTypes {

        debug {
            minifyEnabled false
            debuggable true
            ext.enableCrashlytics = false
            ext.alwaysUpdateBuildId = false
            buildConfigField "String", "BASE_URL", "\"${DevBaseUrl}\""
            //signingConfig signingConfigs.debug
        }

        release {
            minifyEnabled false
            debuggable false
            ext.alwaysUpdateBuildId = false
            ext.enableCrashlytics = true
            buildConfigField "String", "BASE_URL", "\"${ReleaseBaseUrl}\""
            //signingConfig signingConfigs.release
        }

    }

    sourceSets {
        main.java.srcDirs += "${source}"
    }

    easylauncher {
        foregroundIconNames "${forground}"
    }

    lintOptions {
        checkReleaseBuilds false
    }

    testOptions {
        unitTests {
includeAndroidResources = true
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    lintOptions {
        disable 'ContentDescription',
    'ObsoleteLintCustomCheck',
    'CheckResult'
    }

    applicationVariants.all { variant ->
            def profileName
            if (getGradle().getStartParameter().getTaskRequests().toString().contains("Debug")) {
            profileName = "-Debug Version"
                    } else {
            profileName = "-Release Version"
                    }
                    def appName = "Culttrip Client ${profileName}"
                    variant.outputs.all { output ->
            def newApkName
            newApkName = "${appName}-${buildType} -${versionName}.apk"
            output.outputFileName = new File(newApkName)
        }
    }

}

dependencies { configuration ->
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'de.hdodenhof:circleimageview:3.0.1'
    defaultTestingConfiguration(configuration)
    koinConfiguration(configuration)
    googlePlayServicesConfiguration(configuration)
    rxJavaConfiguration(configuration)
    kotlinCoroutines(configuration)
    userInterfaceConfiguration(configuration)
    retrofitConfiguration(configuration)
    applicationConfiguration(configuration)
    vortexConfiguration(configuration)
    daggerConfig(configuration)

    implementation project(":data")
    implementation project(":domain")
}

private void koinConfiguration(configuration) {
    def KoinConfiguration = rootProject.ext.KoinConfiguration
    configuration.implementation KoinConfiguration.KoinAndroid
    configuration.implementation KoinConfiguration.KoinLifecycle
    configuration.implementation KoinConfiguration.KoinViewModel
}

private void googlePlayServicesConfiguration(configuration) {
    def GooglePlayServices = rootProject.ext.GooglePlayServices
    configuration.implementation GooglePlayServices.GoogleMaps
    configuration.implementation GooglePlayServices.GooglePlaces
    configuration.implementation GooglePlayServices.GoogleGcm
    configuration.implementation GooglePlayServices.GoogleLocations
}

private void rxJavaConfiguration(configuration) {
    def RxConfiguration = rootProject.ext.RxConfiguration
    configuration.implementation RxConfiguration.RxJava
    configuration.implementation RxConfiguration.RxAndroid
}

private void kotlinCoroutines(configuration) {
    def KotlinCoroutinesConfiguration = rootProject.ext.KotlinCoroutinesConfiguration
    configuration.implementation KotlinCoroutinesConfiguration.Coroutines
    configuration.implementation KotlinCoroutinesConfiguration.AndroidCoroutines
}

private void userInterfaceConfiguration(configuration) {
    def UiConfiguration = rootProject.ext.UiConfiguration
    configuration.implementation UiConfiguration.RecyclerView
    configuration.implementation UiConfiguration.SupportCompat
    configuration.implementation UiConfiguration.SupportCore
    configuration.implementation UiConfiguration.SupportCoreUi
    configuration.implementation UiConfiguration.SupportFragment
    configuration.implementation UiConfiguration.AndroidCore
    configuration.implementation UiConfiguration.CardView
    configuration.implementation UiConfiguration.AppCompat
    configuration.implementation UiConfiguration.GoogleMaterial
    configuration.implementation UiConfiguration.Fresco
    configuration.implementation UiConfiguration.Sdp
    configuration.implementation UiConfiguration.Constraintlayout
    configuration.implementation UiConfiguration.NavigationFragment
    configuration.implementation UiConfiguration.NavigationUI
}

private void retrofitConfiguration(configuration) {
    def DataConfiguration = rootProject.ext.DataConfiguration
    configuration.implementation DataConfiguration.Retrofit
    configuration.implementation DataConfiguration.RetrofitRxJavaAdapter
    configuration.implementation DataConfiguration.RetrofitIntercenptor
    configuration.implementation DataConfiguration.retrofitGsonConverter
}

private void applicationConfiguration(configuration) {
    def ApplicationConfiguration = rootProject.ext.ApplicationConfiguration
    configuration.implementation ApplicationConfiguration.Timber
    configuration.implementation ApplicationConfiguration.MultiDexApp
    configuration.implementation ApplicationConfiguration.LeakCanaryAndroid
    configuration.implementation ApplicationConfiguration.LeakCanary
    configuration.implementation ApplicationConfiguration.KotlinJdk
}

private void vortexConfiguration(configuration) {
    def VortexConfiguration = rootProject.ext.VortexConfiguration
    configuration.implementation VortexConfiguration.VortexUserInterface
    configuration.implementation VortexConfiguration.VortexPermissions
    configuration.implementation VortexConfiguration.VortexCore
    configuration.implementation VortexConfiguration.VortexLocal
    configuration.implementation VortexConfiguration.VortexData
    configuration.implementation VortexConfiguration.VortexExtras
    configuration.implementation VortexConfiguration.VortexPrefs
}

        """.trimIndent()
    }

    override fun getFileExt(): String {
        return ".gradle"
    }

    override fun getFilePath(): String {
        return "app/build"
    }
}