package io.vortex.android.data

import io.vortex.android.models.VortexAuth
import io.vortex.android.models.VortexRequestDetails
import io.vortex.android.models.VortexRequestDetailsProvider
import io.vortex.android.models.VortexServiceProviderType
import io.vortex.android.rx.VortexRequestProvider

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:44 PM
 */

interface VortexRepositoryImpl<Api , Provider> {

    suspend fun getService(): Api

    fun getBaseUrl(): String

    fun createService(service: Class<Api>): Api

    suspend fun getBasicAuthConfiguration(details: VortexAuth): String

    fun getServiceProvider(type: VortexServiceProviderType): Provider

    fun getRequestDetails(): VortexRequestDetailsProvider

}
