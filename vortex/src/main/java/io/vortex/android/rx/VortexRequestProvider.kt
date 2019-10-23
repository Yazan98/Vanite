package io.vortex.android.rx

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 10:54 PM
 */

class VortexRequestProvider<Result> {

    fun getListObservable(request: Observable<List<Result>>): Observable<List<Result>> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getListFlowable(request: Flowable<List<Result>>): Flowable<List<Result>> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getListSingle(request: Single<List<Result>>): Single<List<Result>> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getListMaybe(request: Maybe<List<Result>>): Maybe<List<Result>> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getObservable(request: Observable<Result>): Observable<Result> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getFlowable(request: Flowable<Result>): Flowable<Result> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getSingle(request: Single<Result>): Single<Result> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    fun getMaybe(request: Maybe<Result>): Maybe<Result> {
        return request
            .subscribeOn(getThreadProvider().getBackgroundThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    private fun getThreadProvider(): VortexThreadProvider = object : VortexThreadProvider {}

}