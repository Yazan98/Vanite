package io.vanite.android.data.executer

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:28 PM
 */

interface VaniteSubscriberHandler<Result, Subscriber : VaniteRequestListener , Request> {

    suspend fun addListener(listener: Subscriber)

    suspend fun subscribeRequest(request: Request)

    suspend fun destroyExecuter()

}