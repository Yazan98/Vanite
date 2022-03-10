package io.vortex.android.errors

import io.vortex.android.models.VortexExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:48 PM
 */

/**
 * This Exception is the base exception for all errors at vortex library to log the exception details at logcat
 */
open class VortexException(details: VortexExceptionDetails<*>) : RuntimeException(details.getExceptionMessage()) {
    init {
        println(
            """
            ${repeatDash()}
            Vortex Exception Started ...
            Exception Message : ${details.getExceptionMessage()}
            Exception Body : ${details.getExceptionBody().toString()}
            Exception Stacktrace : ${this.printStackTrace()}
            Vortex Exception End ...
            ${repeatDash()}
        """.trimIndent()
        )
    }

    private fun repeatDash(): String {
        return "=".repeat(50)
    }

}
