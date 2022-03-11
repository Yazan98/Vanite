package io.vanite.android.data.executer

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:20 PM
 */

interface VaniteRequestListener {

    interface VaniteFlowableRequestListener<Result> : VaniteObservableRequestListener<Result>
    interface VaniteObservableRequestListener<Result> : VaniteRequestListener {
        fun onSuccess(data: Result)
        fun onError(error: Throwable)
        fun onComplete()
    }

    interface VaniteSingleRequestListener<Result> : VaniteRequestListener {
        fun onSuccess(data: Result)
        fun onError(error: Throwable)
    }


}