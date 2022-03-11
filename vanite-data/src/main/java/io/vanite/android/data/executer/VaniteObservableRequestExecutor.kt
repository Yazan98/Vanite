package io.vanite.android.data.executer

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:19 PM
 */

class VaniteObservableRequestExecutor<Result, Listener : VaniteRequestListener.VortexObservableRequestListener<Result>> :
    VaniteSubscriberHandler<Result, Listener, Observable<Result>> {

    private val repo: CompositeDisposable by lazy { CompositeDisposable() }
    private var listener: WeakReference<Listener>? = null

    override suspend fun addListener(listener: Listener) {
        withContext(Dispatchers.IO) {
            this@VaniteObservableRequestExecutor.listener = WeakReference(listener)
        }
    }

    override suspend fun subscribeRequest(request: Observable<Result>) {
        withContext(Dispatchers.IO) {
            repo.add(request.subscribe(
                {
                    it?.let { result ->
                        listener?.let {
                            it.get()?.let {
                                it.onSuccess(result)
                            }
                        }
                    }
                }, {
                    listener?.let {
                        it.get()?.let {
                            it.onError(it as Exception)
                        }
                    }
                }, {
                    listener?.let {
                        it.get()?.let {
                            it.onComplete()
                        }
                    }
                }
            ))
        }
    }

    override suspend fun destroyExecuter() {
        withContext(Dispatchers.IO) {
            repo.clear()
            listener?.clear()
            listener = null
        }
    }


}