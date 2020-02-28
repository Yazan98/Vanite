package io.vortex.cli.starters

import io.vortex.cli.models.VortexAndroidApp

object VortexAndroidStarter : StarterImpl {

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