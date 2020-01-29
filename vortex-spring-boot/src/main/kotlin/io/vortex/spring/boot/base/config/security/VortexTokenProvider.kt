package io.vortex.spring.boot.base.config.security

import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.vortex.spring.boot.base.errors.VortexAuthException
import io.vortex.spring.boot.base.models.TokenErrorDetails
import io.vortex.spring.boot.base.models.TokenInformation
import io.vortex.spring.boot.base.models.VortexTokenDetails
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.*
import javax.servlet.http.HttpServletRequest


/**
 * Created By : Yazan Tarifi
 * Date : 11/6/2019
 * Time : 4:22 AM
 */

abstract class VortexTokenProvider<US : UserDetailsService> {

    private var secreteKey: String

    init {
        secreteKey = Base64.getEncoder().encodeToString(this.getTokenDetails().secreteKey.toByteArray())
    }

    fun createToken(details: ArrayList<TokenInformation>): String {
        val claims = Jwts.claims().setSubject(details[0].value)
        details.forEach {
            claims[it.key] = it.value
        }

        val now = Date()
        val validity = Date(now.time + this.getTokenDetails().validityInMilliseconds)

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, this.secreteKey)
                .compact()
    }

    fun getAuthentication(token: String): Authentication {
        val userDetails = this.getUserService().loadUserByUsername(getUsername(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getUsername(token: String): String {
        return Jwts.parser().setSigningKey(secreteKey).parseClaimsJws(token).body.subject
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7, bearerToken.length)
        } else null
    }

    fun validateToken(token: String): Boolean {
        try {
            if (token.isNotEmpty()) {
                val claims = Jwts.parser().setSigningKey(this.secreteKey).parseClaimsJws(token)
                return !claims.body.expiration.before(Date())
            } else {
                throw VortexAuthException("Token Missing At Header", TokenErrorDetails(
                        "Token Missing ... Should Send Token At Header {Authorization}"
                ))
            }
        } catch (e: JwtException) {
            if (!token.contains("Bearer")) {
                throw VortexAuthException("Expired or invalid JWT token", TokenErrorDetails(
                        "Token Should Be Bearer + Token ... Bearer Missing"
                ))
            } else {
                throw VortexAuthException("Expired or invalid JWT token", TokenErrorDetails(
                        "Token is Invalid Or Missing"
                ))
            }
        } catch (e: IllegalArgumentException) {
            throw VortexAuthException(e.message, TokenErrorDetails(
                    "Token is Invalid Or Expired"
            ))
        }
    }

    protected abstract fun getUserService(): US
    protected abstract fun getTokenDetails(): VortexTokenDetails

}
