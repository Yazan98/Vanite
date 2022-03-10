package io.vortex.android.data.executer

import io.reactivex.Single

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:28 PM
 */

interface VortexSubscriberHandler<Result, Subscriber : VortexRequestListener , Request> {

    suspend fun addListener(listener: Subscriber)

    suspend fun subscribeRequest(request: Request)

    suspend fun destroyExecuter()

}