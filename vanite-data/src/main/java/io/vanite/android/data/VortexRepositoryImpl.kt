package io.vanite.android.data

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:44 PM
 */

interface VortexRepositoryImpl<Api , Provider> {

    suspend fun getService(): Api

    fun getBaseUrl(): String

    fun createService(service: Class<Api>): Api

}
