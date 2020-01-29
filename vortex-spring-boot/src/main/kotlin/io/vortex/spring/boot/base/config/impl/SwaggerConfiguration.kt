package io.vortex.spring.boot.base.config.impl

import springfox.documentation.service.Parameter
import springfox.documentation.spring.web.plugins.Docket

/**
 * Created By : Yazan Tarifi
 * Date : 10/29/2019
 * Time : 10:01 PM
 */

interface SwaggerConfiguration<M> {

    fun getSwaggerConfiguration(): Docket

    fun getSwaggerDetails(): M

    interface SwaggerMultiParamConfiguration<M> : SwaggerConfiguration<M> {
        fun getSwaggerParameters(): ArrayList<Parameter>
    }

}
