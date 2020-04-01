package io.vortex.android.logger

import android.util.Log
import io.vortex.android.logger.config.VortexLoggerConfiguration
import io.vortex.android.logger.keys.VortexLoggerMode

object VortexLog {

    @PublishedApi internal var defaultPreMode: VortexLoggerMode = VortexLoggerConfiguration.getLoggingConfiguration().getDefaultPreMode()
    @PublishedApi internal var defaultPostMode: VortexLoggerMode = VortexLoggerConfiguration.getLoggingConfiguration().getDefaultPostMode()
    @PublishedApi internal var parentTag: String =  VortexLoggerConfiguration.getLoggingConfiguration().getGlobalTag()
    @PublishedApi internal var repeatTime: Int = 50

    inline fun print(message: String, body: () -> Unit) {
        body()
        this printPreMode defaultPreMode
        Log.d(parentTag, message)
        this printPostMode defaultPostMode
        this resetOptionsAfterLog true
    }

    infix fun preMode(mode: VortexLoggerMode) {
        this.defaultPreMode = mode
    }

    infix fun postMode(mode: VortexLoggerMode) {
        this.defaultPostMode = mode
    }

    infix fun currentTag(tag: String) {
        this.parentTag = tag
    }

    infix fun prePost(mode: VortexLoggerMode) {
        this.defaultPreMode = mode
        this.defaultPostMode = mode
    }

    infix fun repeat(count: Int) {
        repeatTime = count
    }

    @PublishedApi internal infix fun printPreMode(mode: VortexLoggerMode) {
        when (mode) {
            VortexLoggerMode.DASH -> {
                for (i in 0..repeatTime) { print("-") }
                println()
            }
            VortexLoggerMode.EQUAL -> {
                for (i in 0..repeatTime) { print("=") }
                println()
            }
            VortexLoggerMode.SLASH -> {
                for (i in 0..repeatTime) { print("/") }
                println()
            }
            VortexLoggerMode.STAR -> {
                for (i in 0..repeatTime) { print("*") }
                println()
            }
        }
    }

    @PublishedApi internal infix fun printPostMode(mode: VortexLoggerMode) {
        when (mode) {
            VortexLoggerMode.DASH -> {
                for (i in 0..repeatTime) { print("-") }
                println()
            }
            VortexLoggerMode.EQUAL -> {
                for (i in 0..repeatTime) { print("=") }
                println()
            }
            VortexLoggerMode.SLASH -> {
                for (i in 0..repeatTime) { print("/") }
                println()
            }
            VortexLoggerMode.STAR -> {
                for (i in 0..repeatTime) { print("*") }
                println()
            }
        }
    }

    @PublishedApi internal infix fun resetOptionsAfterLog(resetMode: Boolean) {
        if (resetMode) {
            defaultPreMode = VortexLoggerConfiguration.getLoggingConfiguration().getDefaultPreMode()
            defaultPostMode = VortexLoggerConfiguration.getLoggingConfiguration().getDefaultPostMode()
            parentTag =  VortexLoggerConfiguration.getLoggingConfiguration().getGlobalTag()
            repeatTime = 50
        }
    }

}
