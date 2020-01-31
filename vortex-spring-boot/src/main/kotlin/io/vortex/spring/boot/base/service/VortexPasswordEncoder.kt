package io.vortex.spring.boot.base.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class VortexPasswordEncoder(private val encoder: BCryptPasswordEncoder) {

    open fun encodePassword(password: String): String {
        return encoder.encode(password)
    }

    open fun validatePassword(encryptedPass: String, newPassword: String): Boolean {
       return encoder.matches(newPassword, encryptedPass)
    }

}
