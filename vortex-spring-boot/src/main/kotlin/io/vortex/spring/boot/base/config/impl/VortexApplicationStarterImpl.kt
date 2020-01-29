package io.vortex.spring.boot.base.config.impl

import io.vortex.spring.boot.base.models.VortexApplicationInfo
import org.springframework.core.env.Environment

/**
 * Created By : Yazan Tarifi
 * Date : 11/5/2019
 * Time : 11:48 PM
 */

interface VortexApplicationStarterImpl {

    fun registerVortexRestTemplate()

    fun getBaseUrl(environment: Environment): String

    fun getApplicationDetails(environment: Environment): VortexApplicationInfo

    fun getSwaggerLink(details: VortexApplicationInfo): String

    fun executePage(url: String)

    fun build(isExecutePageEnabled: Boolean)

}
