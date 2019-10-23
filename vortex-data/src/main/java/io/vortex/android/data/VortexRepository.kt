package io.vortex.android.data

import io.vortex.android.models.VortexAuth
import io.vortex.android.models.VortexServiceProviderType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Credentials
import retrofit2.Retrofit

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:44 PM
 */

abstract class VortexRepository<Api> : VortexRepositoryImpl<Api, Retrofit> {

    open lateinit var serviceProvider: Retrofit

    override suspend fun createService(service: Class<Api>): Api {
        return withContext(Dispatchers.IO) {
            serviceProvider.create(service)
        }
    }

    override suspend fun getBasicAuthConfiguration(details: VortexAuth): String {
        return Credentials.basic(details.username, details.password)
    }

    override suspend fun getServiceProvider(type: VortexServiceProviderType): Retrofit {
        return withContext(Dispatchers.IO) {
            return@withContext when (type) {
                VortexServiceProviderType.BASIC -> VortexRetrofitProvider.getBasicRetrofit(
                    getBaseUrl()
                )
                VortexServiceProviderType.BASIC_REACTIVE -> VortexRetrofitProvider.getReactiveRetrofit(
                    getBaseUrl()
                )
                VortexServiceProviderType.REACTIVE_FULL_LOGGER -> VortexRetrofitProvider.getLoggerReactiveRetrofit(
                    getBaseUrl()
                )
                VortexServiceProviderType.REACTIVE_FULL -> VortexRetrofitProvider.getReactiveFullRetrofit(
                    getBaseUrl(),
                    getRequestDetails()
                )
            }
        }
    }

}
