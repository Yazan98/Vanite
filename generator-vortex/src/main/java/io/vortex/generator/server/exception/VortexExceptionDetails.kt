package io.vortex.generator.server.exception

interface VortexExceptionDetails {
    fun getExceptionError(): VortexAppError
}