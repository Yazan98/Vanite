package io.vortex.android.data

import io.vortex.android.data.interceptor.VortexInterceptor
import io.vortex.android.models.VortexRequestDetails
import io.vortex.android.models.VortexRequestDetailsProvider
import io.vortex.android.models.data.VortexRequestController
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:44 PM
 */

object VortexRetrofitProvider {

    fun getBasicRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getReactiveRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getLoggerReactiveRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getRetrofitLoggingInterceptor())
            .build()
    }

    private fun getRetrofitLoggingInterceptor(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(interceptor)
        return httpClient.build()
    }

    fun getReactiveFullRetrofit(baseUrl: String , requestDetails: VortexRequestDetails): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getReactiveFullClient(requestDetails))
            .build()
    }

    private fun getReactiveFullClient(requestDetails: VortexRequestDetails): OkHttpClient {
        val requestDetailsFull = requestDetails as VortexRequestDetailsProvider
        val httpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor { chain ->
            val request =
                chain.request()
                    .newBuilder()
                    .addHeader("Authorization", requestDetailsFull.token)
                    .addHeader("Accept-Language", requestDetailsFull.language)
                    .build()
            chain.proceed(request)
        }

        return httpClient.build()
    }

    private fun getVortexClient(requestDetails: VortexRequestDetailsProvider): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(VortexInterceptor(requestDetails , VortexRequestController(
            isLoggingEnabled = requestDetails.isLoggingEnabled,
            loggingMode = requestDetails.loggingMode,
            loggingTag = requestDetails.loggingTag
        )))
        return httpClient.build()
    }

    fun getVortexSettingsClient(baseUrl: String , requestDetails: VortexRequestDetailsProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getVortexClient(requestDetails))
            .build()
    }
}
