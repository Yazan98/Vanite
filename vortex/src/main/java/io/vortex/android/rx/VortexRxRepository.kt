package io.vortex.android.rx

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 10:52 PM
 */

class VortexRxRepository {

    private val repo: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun addRequest(request: Disposable) {
        this.repo.add(request)
    }

    fun clearRepository() {
        this.repo.clear()
    }

}
