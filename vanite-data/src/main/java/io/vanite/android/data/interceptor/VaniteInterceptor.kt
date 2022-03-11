package io.vanite.android.data.interceptor

import android.util.Log
import io.vanite.android.models.VaniteRequestDetailsProvider
import io.vanite.android.models.data.VaniteInterceptorMode
import io.vanite.android.models.data.VaniteRequestController
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created By : Yazan Tarifi
 * Date : 12/25/2019
 * Time : 12:12 AM
 */

class VaniteInterceptor(
    private val requestDetails: VaniteRequestDetailsProvider,
    private val requestController: VaniteRequestController
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest =
            chain.request()
                .newBuilder()
                .addHeader("Authorization", requestDetails.token)
                .addHeader("Accept-Language", requestDetails.language)
                .build()

        return when (requestController.loggingMode) {
            VaniteInterceptorMode.NONE -> chain.proceed(newRequest)
            VaniteInterceptorMode.HEADER -> getHeadersInterceptor(chain, newRequest)
            VaniteInterceptorMode.FULL -> getFullInformationInterceptor(chain, newRequest)
        }
    }

    private fun getFullInformationInterceptor(
        chain: Interceptor.Chain,
        request: Request
    ): Response {
        return when (requestController.isLoggingEnabled) {
            true -> {
                val response = chain.proceed(request)
                printHeader()
                logFullRequestInformation(request , response)
                printFooter()
                return response
            }

            false -> chain.proceed(request)
        }
    }

    private fun getHeadersInterceptor(chain: Interceptor.Chain, request: Request): Response {
        return when (requestController.isLoggingEnabled) {
            true -> {
                val response = chain.proceed(request)
                printHeader()
                logHeadersAtRequestResponse(request, response)
                printFooter()
                return response
            }

            false -> chain.proceed(request)
        }
    }

    private fun logFullRequestInformation(request: Request, response: Response) {
        Log.d(requestController.loggingTag , "Full Mode Started ...")
        Log.d(requestController.loggingTag , "Request Url : ${request.url}")
        Log.d(requestController.loggingTag , "Request Method : ${request.method}")
        if (request.body != null) {
            Log.d(requestController.loggingTag , "Request ${request.body.toString()}")
        } else {
            Log.d(requestController.loggingTag , "Request Body : (No Body At Request) : ${request.method}")
        }
        Log.d(requestController.loggingTag , "Request Headers : ${getFilteredHeaders(request.headers)}")
        Log.d(requestController.loggingTag , """
            Response Information 
            Message : ${response.message}
            Code : ${response.code}
            Status (Successful) : ${response.isSuccessful}
            Is Re Direct : ${response.isRedirect}
            Response Body Content Type : ${response.body?.contentType()}
            Response Time : ${response.sentRequestAtMillis}
        """.trimIndent())
        Log.d(requestController.loggingTag, "Response Body " + response.body?.string())
        //Response Body : ${Gson().toJson(response.body)}
    }

    private fun logHeadersAtRequestResponse(request: Request, response: Response) {
        Log.d(requestController.loggingTag , "Headers Mode Started ...")
        Log.d(requestController.loggingTag , "Request Url : ${request.url}")
        Log.d(requestController.loggingTag , "Request Method : ${request.method}")
        if (request.method.equals("POST") || request.method.equals("PUT")) {
            Log.d(requestController.loggingTag , "Request ${request.body}")
        } else {
            Log.d(requestController.loggingTag , "Request Body : (No Body At Request) : ${request.method}")
        }
        Log.d(requestController.loggingTag , "Request Headers : ${getFilteredHeaders(request.headers)}")
    }

    private fun getFilteredHeaders(headers: Headers): String {
        var result = ""
        headers.forEach {
            result += "Name : ${it.first} , Value : ${it.second} \n"
        }
        return result
    }

    private fun printHeader() {
        if (requestController.isLoggingEnabled) {
            println("======================================= Vanite Logger Started =======================================")
        }
    }

    private fun printFooter() {
        if (requestController.isLoggingEnabled) {
            println("=====================================================================================================")
        }
    }

}
