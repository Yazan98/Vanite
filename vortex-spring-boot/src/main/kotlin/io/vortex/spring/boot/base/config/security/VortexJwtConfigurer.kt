package io.vortex.spring.boot.base.config.security

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


/**
 * Created By : Yazan Tarifi
 * Date : 11/6/2019
 * Time : 4:18 AM
 */

open class VortexJwtConfigurer(private val provider: VortexTokenProvider<*>) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity?) {
        val customFilter = VortexJwtTokenFilter(provider)
        builder?.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

}
