package io.vortex.cli.models

data class VortexAndroidApp(
        var name: String = "Vortex App",
        var packageName: String = "io.vortex.app",
        var isMultiModularApp: Boolean = true,
        var isGooglePlayPublishEnabled: Boolean = true,
        var isCodeSampleEnabled: Boolean = true
)
