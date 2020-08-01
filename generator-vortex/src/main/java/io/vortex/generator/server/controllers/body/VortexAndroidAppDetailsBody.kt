package io.vortex.generator.server.controllers.body

import io.vortex.generator.server.VortexAppKeys
import io.vortex.generator.server.models.keys.VortexAndroidAppReadmeType

data class VortexAndroidAppDetailsBody(
        var applicationName: String? = VortexAppKeys.DEFAULT_ANDROID_APP_NAME,
        var applicationVersionName: String? = VortexAppKeys.VORTEX_APPLICATION_VERSION,
        var applicationPackageName: String? = VortexAppKeys.VORTEX_PACKAGE_NAME_DEFAULT_VALUE,
        var applicationMinSdkVersion: Int? = VortexAppKeys.VORTEX_APPLICATION_MIN_SDK_VERSION,
        var applicationTargetSdkVersion: Int? = VortexAppKeys.VORTEX_APPLICATION_TARGET_SDK_VERSION,
        var isVersionNameDependsOnGitRemote: Boolean? = VortexAppKeys.VORTEX_VERSION_NAME_CONNECTED_WITH_GIT_DEFAULT_VALUE,
        var isAppMultiFlavor: Boolean? = VortexAppKeys.VORTEX_APP_IS_MULTI_FLAVORS_DEFAULT_VALUE,
        var isGradleConfigurationMultiFiles: Boolean? = VortexAppKeys.VORTEX_GRADLE_CONFIGURATION_MULTI_FILE_DEFAULT_VALUE,
        var isMultiModularApp: Boolean? = VortexAppKeys.VORTEX_APP_MULTI_MODULAR_APP_DEFAULT_VALUE,
        var isHttpsAppLevelEnabled: Boolean? = VortexAppKeys.VORTEX_IS_HTTPS_ENABLED_APP_LEVEL_DEFAULT_VALUE,
        var appReadmeType: VortexAndroidAppReadmeType? = VortexAndroidAppReadmeType.VORTEX,
        var isGoogleMapsEnabled: Boolean? = VortexAppKeys.VORTEX_ANDROID_APP_IS_GOOGLE_MAPS_ENABLED,
        var isCrashReportingEnabled: Boolean? = VortexAppKeys.VORTEX_ANDROID_APP_CRASH_REPORTING_ENABLED,
        var applicationApiBaseUrl: String? = VortexAppKeys.VORTEX_ANDROID_APP_BASE_URL_API
)
