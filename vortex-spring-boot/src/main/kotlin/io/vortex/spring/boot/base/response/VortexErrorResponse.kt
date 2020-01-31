package io.vortex.spring.boot.base.response

import io.vortex.spring.boot.base.errors.ErrorDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/30/2019
 * Time : 9:07 PM
 */
data class VortexErrorResponse(
        val code: Int,
        val message: String?,
        val status: String = "Failed",
        val error: VortexError,
        val path: String?
) : VortexResponse

data class VortexCustomErrorResponse(
        val code: Int,
        val message: String?,
        val status: String = "Failed",
        val path: String?,
        val stacktrace: Array<StackTraceElement>
): VortexResponse

data class VortexError(
        val type: String,
        val details: ErrorDetails,
        val stacktrace: Array<StackTraceElement>
) : ErrorDetails {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VortexError

        if (type != other.type) return false
        if (details != other.details) return false
        if (!stacktrace.contentEquals(other.stacktrace)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + details.hashCode()
        result = 31 * result + stacktrace.contentHashCode()
        return result
    }
}