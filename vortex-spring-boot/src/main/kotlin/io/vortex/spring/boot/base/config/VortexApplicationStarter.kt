package io.vortex.spring.boot.base.config

import io.vortex.spring.boot.base.config.impl.VortexApplicationStarterImpl
import io.vortex.spring.boot.base.models.VortexApplicationInfo
import org.springframework.core.env.Environment
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.util.Collections.singletonList

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:48 PM
 */

class VortexApplicationStarter(private val environment: Environment) : VortexApplicationStarterImpl {

    override fun registerVortexRestTemplate() {
        val factory = BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory())
        val restTemplate = RestTemplate(factory)
        restTemplate.interceptors = singletonList(VortexResponseLogger()) as List<ClientHttpRequestInterceptor>
    }

    override fun getBaseUrl(environment: Environment): String {
        return "http://${getApplicationDetails(environment).address}:${getApplicationDetails(environment).port}"
    }

    override fun getSwaggerLink(details: VortexApplicationInfo): String {
        return "${getBaseUrl(environment)}/swagger-ui.html"
    }

    override fun getApplicationDetails(environment: Environment): VortexApplicationInfo {
        return VortexApplicationInfo(
                address = environment.getProperty("server.address", "localhost"),
                name = environment.getProperty("spring.application.name", "Vortex Application"),
                port = environment.getProperty("server.port", "8090").toInt()
        )
    }

    override fun executePage(url: String) {
        val rt = Runtime.getRuntime()
        rt.exec("rundll32 url.dll,FileProtocolHandler $url")
    }

    override fun build(isExecutePageEnabled: Boolean) {
        val details = getApplicationDetails(environment)
        println("""
            =========================================================================================================
            Vortex Application Started ....
            Application Name : ${details.name}
            Application Base Url : ${getBaseUrl(environment)}
            Application Address : ${details.address}
            Application Port : ${details.port}
            Swagger Link : ${getSwaggerLink(details)}
            =========================================================================================================
        """.trimIndent())
    }

}
