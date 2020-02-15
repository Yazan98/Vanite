package io.vortex.intellij.plugin.modules.content

import io.vortex.intellij.plugin.modules.VortexContent

data class VortexAboutPluginContent(
    val title: String = "About Plugin",
    val description: String = "Vortex is An Archetecture To Build Android Applications With Latest Technologies , Kotlin Language" +
            "To Generate , Support Common Cases , Configuration For Android Platform",
    val links: String = """
        Vortex Version 1.0.0
        Vortex Github Link : https://github.com/Yazan98/Vortex
        Generated Code Language : Kotlin
    """.trimIndent(),
    val supportedGenerators: List<String> = arrayListOf(
        "1.Activities",
        "2.Fragments (Templates / Custom)",
        "3. Services , Notifications",
        "4.ViewModels (Logic Implementation)",
        "5.Crud Repositories (Api)",
        "6.Crud Local Databases",
        "7.Application Configuration",
        "8.Gradle Application Configuration",
        "9.Api Models",
        "10. Common Configuration About Android Applications"
    )
): VortexContent
