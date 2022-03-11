package io.vanite.android.data.executer

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 2:19 PM
 */

class VaniteSingleRequestExecutor<Result, Listener : VaniteRequestListener.VaniteSingleRequestListener<Result>> :
    VaniteSubscriberHandler<Result, Listener , Single<Result>> {

    private val repo: CompositeDisposable by lazy { CompositeDisposable() }
    private var listener: WeakReference<Listener>? = null

    override suspend fun addListener(listener: Listener) {
        withContext(Dispatchers.IO) {
            this@VaniteSingleRequestExecutor.listener = WeakReference(listener)
        }
    }

    override suspend fun subscribeRequest(request: Single<Result>) {
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