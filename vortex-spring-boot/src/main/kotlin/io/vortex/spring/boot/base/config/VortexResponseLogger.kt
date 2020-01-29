package io.vortex.spring.boot.base.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.util.StreamUtils
import java.io.IOException
import java.nio.charset.Charset


/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:52 PM
 */

class VortexResponseLogger : ClientHttpRequestInterceptor {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun intercept(request: HttpRequest, body: ByteArray, execution: ClientHttpRequestExecution): ClientHttpResponse {
        logRequest(request, body)
        val response = execution.execute(request, body)
        logResponse(response)
        return response
    }

    @Throws(IOException::class)
    fun logRequest(request: HttpRequest, body: ByteArray) {
        if (log.isDebugEnabled) {
            log.debug("===========================request begin================================================")
            log.debug("URI         : {}", request.uri)
            log.debug("Method      : {}", request.method)
            log.debug("Headers     : {}", request.headers)
            log.debug("Request body: {}", String(body, charset("UTF-8")))
            log.debug("==========================request end================================================")
        }
    }

    @Throws(IOException::class)
    fun logResponse(response: ClientHttpResponse) {
        if (log.isDebugEnabled) {
            log.debug("============================response begin==========================================")
            log.debug("Status code  : {}", response.statusCode)
            log.debug("Status text  : {}", response.statusText)
            log.debug("Headers      : {}", response.headers)
            log.debug("Response body: {}", StreamUtils.copyToString(response.body, Charset.defaultCharset()))
            log.debug("=======================response end=================================================")
        }
    }

    @Bean
    fun loggingInterceptor(): VortexResponseLogger {
        return VortexResponseLogger()
    }
}