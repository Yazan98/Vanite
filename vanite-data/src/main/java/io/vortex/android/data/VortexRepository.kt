package io.vortex.android.data

import io.vortex.android.models.VortexAuth
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

    override fun createService(service: Class<Api>): Api {
        return serviceProvider.create(service)
    }

}
