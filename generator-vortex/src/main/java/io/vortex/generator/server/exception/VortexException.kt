package io.vortex.generator.server.exception

abstract class VortexException(
        override val message: String?,
        private val appError: VortexAppError
) : Exception(message), VortexExceptionDetails {
    override fun getExceptionError(): VortexAppError {
        return appError
    }
}
