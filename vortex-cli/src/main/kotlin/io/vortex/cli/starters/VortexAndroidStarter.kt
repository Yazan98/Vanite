package io.vortex.cli.starters

import io.vortex.cli.models.VortexAndroidApp
import java.util.*

object VortexAndroidStarter : StarterImpl {

    private val questionInput: Scanner by lazy { Scanner(System.`in`) }
    private val androidApplicationDetails: VortexAndroidApp by lazy {
        VortexAndroidApp()
    }

    override fun startAppGenerator() {
        println("Android Application Started ...")
        println("""
            ============================================================================================================
            Application Info 
            Language : Kotlin
            Main Environment : Multi Modular Application
            Main Archeticture : Mvvm , Redux
            ============================================================================================================
        """.trimIndent())
        println()
        print("What is The Project Name (Default is Vortex App) ? ")
        when (val appName = questionInput.next().trim()) {
            "" -> this.androidApplicationDetails.name = "Vortex App"
            else -> this.androidApplicationDetails.name = appName
        }

        println()
        print("What is The Package Name (Default is io.vortex.app) ? ")
        when (val packageName = questionInput.next().trim()) {
            "" -> this.androidApplicationDetails.name = "io.vortex.app"
            else -> this.androidApplicationDetails.packageName = packageName
        }

        println()
        print("Do you Need The Multi Modular Application (Default is Enabled)  A.N [y,n] ? ")
        when (questionInput.next().trim()) {
            "" -> this.androidApplicationDetails.isMultiModularApp = true
            "y" -> this.androidApplicationDetails.isMultiModularApp = true
            "n" -> this.androidApplicationDetails.isMultiModularApp = false
        }

        println()
        print("Do you want To Publish The Application On Google Play (Default is Yes) A.N [y,n] ? ")
        when (questionInput.next().trim()) {
            "" -> this.androidApplicationDetails.isGooglePlayPublishEnabled = true
            "y" -> this.androidApplicationDetails.isGooglePlayPublishEnabled = true
            "n" -> this.androidApplicationDetails.isGooglePlayPublishEnabled = false
        }

        println()
        print("Do you want To Generate Sample Code (Default is Yes) A.N [y,n] ? ")
        when (questionInput.next().trim()) {
            "" -> this.androidApplicationDetails.isCodeSampleEnabled = true
            "y" -> this.androidApplicationDetails.isCodeSampleEnabled = true
            "n" -> this.androidApplicationDetails.isCodeSampleEnabled = false
        }

        println()
        println("""
            Project Generator Started ...
            =========================================================================================================
            Application Name : ${androidApplicationDetails.name}
            Package Name : ${androidApplicationDetails.packageName}
            ${getAppArche()}
            ${googlePlayOptions()}
            ${isCodeEnabled()}
            =========================================================================================================
        """.trimIndent())
    }

    private fun isCodeEnabled(): String {
        return if(androidApplicationDetails.isCodeSampleEnabled) {
            "The Code Sample Enabled ..."
        } else {
            "The Code Sample Disabled ..."
        }
    }

    private fun googlePlayOptions(): String {
        return if(androidApplicationDetails.isGooglePlayPublishEnabled) {
            "Google Play Configuration Enabled For This Project"
        } else {
            "Google Play Configuration Disabled For This Project"
        }
    }

    private fun getAppArche(): String {
        return if(androidApplicationDetails.isMultiModularApp) {
            "The Application is Multi Modular Application"
        } else {
            "The Application is Single Module Application"
        }
    }

    override fun startConfigurationFilesGenerator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startGradleConfigurationGenerator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startExampleCodeGenerator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}