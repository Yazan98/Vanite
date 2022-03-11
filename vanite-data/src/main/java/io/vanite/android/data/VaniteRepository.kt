package io.vanite.android.data

import retrofit2.Retrofit

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:44 PM
 */

abstract class VaniteRepository<Api> : VaniteRepositoryImpl<Api, Retrofit> {

    open lateinit var serviceProvider: Retrofit

    override fun createService(service: Class<Api>): Api {
        return serviceProvider.create(service)
    }

}
