package io.vortex.android.data.executer

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:20 PM
 */

interface VortexRequestListener

interface VortexFlowableRequestListener<Result> : VortexObservableRequestListener<Result>
interface VortexObservableRequestListener<Result> : VortexRequestListener {
    suspend fun onSuccess(data: Result)
    suspend fun onError(error: Throwable)
    suspend fun onComplete()
}

interface VortexSingleRequestListener<Result> : VortexRequestListener {
    suspend fun onSuccess(data: Result)
    suspend fun onError(error: Throwable)
}

