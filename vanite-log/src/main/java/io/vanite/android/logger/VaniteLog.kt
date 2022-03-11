package io.vanite.android.logger

import android.util.Log
import io.vanite.android.logger.config.VaniteLoggerConfiguration
import io.vanite.android.logger.keys.VaniteLoggerLevel
import io.vanite.android.logger.keys.VaniteLoggerMode
import io.vanite.android.logger.keys.VaniteLoggingStatus

/**
 * This is The Main Class For Vanite Logger To Log The Android Messages
 * Short Example :
 *
 * VaniteLog.print("Your Message Here") {
        VaniteLog prePost VaniteLoggerMode.DASH
        VaniteLog currentTag "Crate Account Request"
        VaniteLog repeat 100
   }

 Another Example About Custom Logging Levels For Debug, Error , Warning
VaniteLog.printLevel("The Error Message") {
        VaniteLog attachLevel VaniteLoggerLevel.ERROR
        VaniteLog prePost VaniteLoggerMode.EQUAL
        VaniteLog repeat 50
    }

 */
object VaniteLog {

    @PublishedApi internal var defaultPreMode: VaniteLoggerMode = VaniteLoggerConfiguration.getLoggingConfiguration().getDefaultPreMode()
    @PublishedApi internal var defaultPostMode: VaniteLoggerMode = VaniteLoggerConfiguration.getLoggingConfiguration().getDefaultPostMode()
    @PublishedApi internal var parentTag: String =  VaniteLoggerConfiguration.getLoggingConfiguration().getGlobalTag()
    @PublishedApi internal var defaultLevel: VaniteLoggerLevel = VaniteLoggerConfiguration.getLoggingConfiguration().getDefaultLevel()
    @PublishedApi internal var repeatTime: Int = 50

    inline fun print(message: String, body: () -> Unit = {}) {
        if (VaniteLoggerConfiguration.getLoggingConfiguration().getLoggingStatus() == VaniteLoggingStatus.ENABLED) {
            body()
            this printPreMode defaultPreMode
            Log.d(parentTag, message)
            this printPostMode defaultPostMode
            this resetOptionsAfterLog true
        }
    }

    inline fun printLevel(message: String, body: () -> Unit = {}) {
        if (VaniteLoggerConfiguration.getLoggingConfiguration().getLoggingStatus() == VaniteLoggingStatus.ENABLED) {
            body()
            this printPreMode defaultPreMode
            printLevelWithMessage(message, defaultLevel)
            this printPostMode defaultPostMode
            this resetOptionsAfterLog true
        }
    }

    infix fun preMode(mode: VaniteLoggerMode) {
        this.defaultPreMode = mode
    }

    infix fun postMode(mode: VaniteLoggerMode) {
        this.defaultPostMode = mode
    }

    infix fun currentTag(tag: String) {
        this.parentTag = tag
    }

    infix fun attachLevel(level: VaniteLoggerLevel) {
        this.defaultLevel = level
    }

    infix fun prePost(mode: VaniteLoggerMode) {
        this.defaultPreMode = mode
        this.defaultPostMode = mode
    }

    infix fun repeat(count: Int) {
        repeatTime = count
    }

    @PublishedApi internal fun printLevelWithMessage(message: String, mode: VaniteLoggerLevel) {
        when (mode) {
            VaniteLoggerLevel.DEBUG -> Log.d(parentTag, message)
            VaniteLoggerLevel.ERROR -> Log.e(parentTag, message)
            VaniteLoggerLevel.WARNING -> Log.w(parentTag, message)
        }
    }

    @PublishedApi internal infix fun printPreMode(mode: VaniteLoggerMode) {
        when (mode) {
            VaniteLoggerMode.DASH -> {
                for (i in 0..repeatTime) { print("-") }
                println()
            }
            VaniteLoggerMode.EQUAL -> {
                for (i in 0..repeatTime) { print("=") }
                println()
            }
            VaniteLoggerMode.SLASH -> {
                for (i in 0..repeatTime) { print("/") }
                println()
            }
            VaniteLoggerMode.STAR -> {
                for (i in 0..repeatTime) { print("*") }
                println()
            }
        }
    }

    @PublishedApi internal infix fun printPostMode(mode: VaniteLoggerMode) {
        when (mode) {
            VaniteLoggerMode.DASH -> {
                for (i in 0..repeatTime) { print("-") }
                println()
            }
            VaniteLoggerMode.EQUAL -> {
                for (i in 0..repeatTime) { print("=") }
                println()
            }
            VaniteLoggerMode.SLASH -> {
                for (i in 0..repeatTime) { print("/") }
                println()
            }
            VaniteLoggerMode.STAR -> {
                for (i in 0..repeatTime) { print("*") }
                println()
            }
        }
    }

    @PublishedApi internal infix fun resetOptionsAfterLog(resetMode: Boolean) {
        if (resetMode) {
            defaultPreMode = VaniteLoggerConfiguration.getLoggingConfiguration().getDefaultPreMode()
            defaultPostMode = VaniteLoggerConfiguration.getLoggingConfiguration().getDefaultPostMode()
            parentTag =  VaniteLoggerConfiguration.getLoggingConfiguration().getGlobalTag()
            repeatTime = 50
        }
    }

}
