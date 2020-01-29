package io.vortex.spring.boot.base.config.security

import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

/**
 * Created By : Yazan Tarifi
 * Date : 11/6/2019
 * Time : 4:43 AM
 */

abstract class VortexSecurityConfig : WebSecurityConfigurerAdapter() {

    protected val AUTH_WHITELIST = arrayOf("/v2/api-docs",
            "/swagger-resources", "/swagger-resources/**",
            "/configuration/ui", "/configuration/security",
            "/swagger-ui.html", "/webjars/**")

    override fun configure(web: WebSecurity?) {
        web?.ignoring()!!.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }

    override fun configure(http: HttpSecurity?) {
        http?.let {
            it.httpBasic().disable()
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers(AUTH_WHITELIST[0]).permitAll()
                    .antMatchers(AUTH_WHITELIST[1]).permitAll()
                    .antMatchers(AUTH_WHITELIST[2]).permitAll()
                    .antMatchers(AUTH_WHITELIST[3]).permitAll()
                    .antMatchers(AUTH_WHITELIST[4]).permitAll()
                    .antMatchers(AUTH_WHITELIST[5]).permitAll()
                    .antMatchers(AUTH_WHITELIST[6]).permitAll()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .apply(VortexJwtConfigurer(getTokenProvider()))
            configWebSecurity(it)
        }
    }

    protected abstract fun configWebSecurity(http: HttpSecurity)
    protected abstract fun getTokenProvider(): VortexTokenProvider<*>
}