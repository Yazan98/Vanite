package io.vanite.android.data

import io.vanite.android.data.interceptor.VaniteInterceptor
import io.vanite.android.models.VaniteRequestDetails
import io.vanite.android.models.VaniteRequestDetailsProvider
import io.vanite.android.models.data.VaniteRequestController
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

object VaniteRetrofitProvider {

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

    fun getReactiveFullRetrofit(baseUrl: String , requestDetails: VaniteRequestDetails): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getReactiveFullClient(requestDetails))
            .build()
    }

    private fun getReactiveFullClient(requestDetails: VaniteRequestDetails): OkHttpClient {
        val requestDetailsFull = requestDetails as VaniteRequestDetailsProvider
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

    private fun getVaniteClient(requestDetails: VaniteRequestDetailsProvider): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(VaniteInterceptor(requestDetails , VaniteRequestController(
            isLoggingEnabled = requestDetails.isLoggingEnabled,
            loggingMode = requestDetails.loggingMode,
            loggingTag = requestDetails.loggingTag
        )))
        return httpClient.build()
    }

    fun getVaniteSettingsClient(baseUrl: String, requestDetails: VaniteRequestDetailsProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getVaniteClient(requestDetails))
            .build()
    }
}
