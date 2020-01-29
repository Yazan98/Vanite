package io.vortex.spring.boot.base.config


import io.vortex.spring.boot.base.models.VortexResponseHeader
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse


/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:39 PM
 */

abstract class VortexResponseHeaderFilter : Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val result = response as HttpServletResponse
        getHeaders().forEach {
            result.setHeader(it.key, it.value)
        }
        chain?.doFilter(request, result)
    }

    protected abstract fun getHeaders(): List<VortexResponseHeader>
}