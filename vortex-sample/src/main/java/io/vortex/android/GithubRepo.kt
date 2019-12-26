package io.vortex.android

import io.reactivex.Single
import io.vortex.android.data.VortexRepository
import io.vortex.android.models.VortexRequestDetails
import io.vortex.android.models.VortexRequestDetailsProvider
import io.vortex.android.models.VortexServiceProviderType
import io.vortex.android.rx.VortexRequestProvider
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created By : Yazan Tarifi
 * Date : 12/25/2019
 * Time : 12:57 AM
 */

class GithubRepo : VortexRepository<GithubRepo.Api>() {

    interface Api {
        @GET("users/Yazan98")
        fun getUserDetails(
            @Header("Auth") auth: String, @Header("Main-Header") header: String
        ): Single<GithubUser>
    }

    override suspend fun getService(): Api {
        return getServiceProvider(VortexServiceProviderType.VORTEX_SETTINGS).create(Api::class.java)
    }

    override suspend fun getBaseUrl(): String {
        return "https://api.github.com/"
    }

    override suspend fun <T : Any> getRequestProvider(): VortexRequestProvider<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRequestDetails(): VortexRequestDetailsProvider {
        return VortexRequestDetailsProvider()
    }
}