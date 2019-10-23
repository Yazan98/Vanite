package io.vortex.android.data

import io.vortex.android.models.VortexAuth
import io.vortex.android.models.VortexRequestDetails
import io.vortex.android.models.VortexServiceProviderType
import io.vortex.android.rx.VortexRequestProvider

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:44 PM
 */

interface VortexRepositoryImpl<Api , Provider> {

    suspend fun getService(): Api

    suspend fun getBaseUrl(): String

    suspend fun createService(service: Class<Api>): Api

    suspend fun getBasicAuthConfiguration(details: VortexAuth): String

    suspend fun getServiceProvider(type: VortexServiceProviderType): Provider

    suspend fun <T : Any> getRequestProvider(): VortexRequestProvider<T>

    fun getRequestDetails(): VortexRequestDetails

}
