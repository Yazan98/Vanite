package io.vanite.android.data.executer

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:20 PM
 */

interface VaniteRequestListener {

    interface VortexFlowableRequestListener<Result> : VortexObservableRequestListener<Result>
    interface VortexObservableRequestListener<Result> : VaniteRequestListener {
        fun onSuccess(data: Result)
        fun onError(error: Throwable)
        fun onComplete()
    }

    interface VortexSingleRequestListener<Result> : VaniteRequestListener {
        fun onSuccess(data: Result)
        fun onError(error: Throwable)
    }


}