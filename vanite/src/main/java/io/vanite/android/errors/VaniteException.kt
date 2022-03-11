package io.vanite.android.errors

import io.vanite.android.models.VaniteExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:48 PM
 */

/**
 * This Exception is the base exception for all errors at Vanite library to log the exception details at logcat
 */
open class VaniteException(details: VaniteExceptionDetails<*>) : RuntimeException(details.getExceptionMessage()) {
    init {
        println(
            """
            ${repeatDash()}
            Vanite Exception Started ...
            Exception Message : ${details.getExceptionMessage()}
            Exception Body : ${details.getExceptionBody().toString()}
            Exception Stacktrace : ${this.printStackTrace()}
            Vanite Exception End ...
            ${repeatDash()}
        """.trimIndent()
        )
    }

    private fun repeatDash(): String {
        return "=".repeat(50)
    }

}
