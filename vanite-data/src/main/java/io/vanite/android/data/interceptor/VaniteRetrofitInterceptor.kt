package io.vanite.android.data.interceptor

import android.util.Log.d
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class VaniteRetrofitInterceptor : Interceptor {

    companion object {
        const val AUTH = "Authorization"
        const val LANGUAGE = "Accept-Language"
        const val REQUEST_TAG = "Vanite Request"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(chain.request())
        printRequestLog("""
            Reflex Request Started ...
            With Url : ${request.url}
        """.trimIndent())
        response.body?.let {
            val rawJson = it.string()
            val contentType = it.contentType()
            val body = ResponseBody.create(contentType, rawJson)
            printRequestLog("""
                Reflex Request Finished With ${response.receivedResponseAtMillis} ms
                Response Code : ${response.code}
                Response Message : ${response.message}
            """.trimIndent())
            printRequestLog("Response Body : " + body.string())
        }
        printRequestLog("""
            Reflex Request With Url : ${request.url}
            Finished With Code : ${response.code}
        """.trimIndent())
        return response
    }

    private fun printRequestLog(message: String) {
        d(REQUEST_TAG, message)
    }


}
