package io.vortex.spring.boot.base.models

/**
 * Created By : Yazan Tarifi
 * Date : 10/29/2019
 * Time : 10:04 PM
 */

data class VortexSwaggerDetails(
        val title: String,
        val description: String,
        val contact: SwaggerContact,
        val license: String,
        val licenseUrl: String,
        val version: String
)

data class SwaggerContact(
        val name: String,
        val email: String,
        val website: String
)