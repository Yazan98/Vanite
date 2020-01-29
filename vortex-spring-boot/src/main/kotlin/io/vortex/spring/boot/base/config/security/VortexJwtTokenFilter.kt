package io.vortex.spring.boot.base.config.security

import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.http.HttpServletRequest



/**
 * Created By : Yazan Tarifi
 * Date : 11/6/2019
 * Time : 4:23 AM
 */

open class VortexJwtTokenFilter(private val provider: VortexTokenProvider<*>) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token = provider.resolveToken(request as HttpServletRequest)
        if (token != null && provider.validateToken(token)) {
            val auth = provider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = auth
        }
        chain?.doFilter(request, response)
    }

}
