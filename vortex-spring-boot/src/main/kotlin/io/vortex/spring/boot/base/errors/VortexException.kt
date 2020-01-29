package io.vortex.spring.boot.base.errors

/**
 * Created By : Yazan Tarifi
 * Date : 10/27/2019
 * Time : 11:32 PM
 */

open class VortexException(override val message: String?, private val details: ErrorDetails) : Exception(message) {
    protected fun logException(error: VortexException) {
        println("""
            ===========================================================================================================
            Vortex Exception Started : ${error.javaClass.simpleName}
            Exception Message : ${error.message}
            Exception Details : ${error.details}
            Exception Stacktrace : ${error.printStackTrace()}
            ===========================================================================================================
        """.trimIndent())
    }

    fun getDetails(): ErrorDetails = details
}

data class VortexMethodError(
        val method: String,
        val reason: String
) : ErrorDetails

data class EmptyResultError(
        val reason: String
) : ErrorDetails
