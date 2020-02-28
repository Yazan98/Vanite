package io.vortex.cli

import io.vortex.cli.models.VortexAndroidApp
import io.vortex.cli.models.VortexEnv
import io.vortex.cli.starters.VortexAndroidStarter
import io.vortex.cli.starters.VortexSpringStarter
import java.util.*

object VortexPrinter {

    private lateinit var env: VortexEnv
    private val questionInput: Scanner by lazy {
        Scanner(System.`in`)
    }

    fun printCliDetails() {
        println(App().greeting)
        println("Welcome To Vortex Cli")
        println("Vortex Project Starter ...")
        println("Version 1.0.0")
        println("Vortex Link : https://github.com/Yazan98/Vortex")
        println()
        println("Vortex CLI : Build Your Application With All Configuration in 1 sec")
        println("Vortex CLI Can Generate Android, SpringBoot Applications, Build The Project")
        println()
    }

    fun printTheEnvironments() {
        println()
        print("Choose Your Environment : ")
        loop@ while (true) {
            when (questionInput.next()) {
                "Android" -> {
                    env = VortexEnv.ANDROID
                    break@loop
                }
                "SpringBoot" -> {
                    env = VortexEnv.SPRINGBOOT
                    break@loop
                }
                else -> {
                    "Wrong Input ... You Should Pick One Of The Supported Environments (Android, SpringBoot)"
                    continue@loop
                }
            }
        }
        when (env) {
            VortexEnv.ANDROID -> VortexAndroidStarter.startAppGenerator()
            VortexEnv.SPRINGBOOT -> VortexSpringStarter.startAppGenerator()
        }
    }

}
