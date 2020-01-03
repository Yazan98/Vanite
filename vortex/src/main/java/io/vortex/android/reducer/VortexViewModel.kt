package io.vortex.android.reducer

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.vortex.android.VortexAction
import io.vortex.android.VortexNetworkListener
import io.vortex.android.VortexRxReducer
import io.vortex.android.VortexRxStore
import io.vortex.android.rx.VortexRxRepository
import io.vortex.android.state.VortexState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:32 AM
 */

abstract class VortexViewModel<State : VortexState, Action : VortexAction> : ViewModel(),
    VortexRxReducer<State, Action, VortexStore<State>, MutableLiveData<State>> {

    private val reducerStore: MutableLiveData<VortexStore<State>> by lazy {
        MutableLiveData<VortexStore<State>>()
    }

    private var networkLister: VortexNetworkListener? = null
    private val repo: VortexRxRepository by lazy {
        VortexRxRepository()
    }

    init {
        GlobalScope.launch {
            if (reducerStore.value == null) {
                reducerStore.postValue(VortexStore())
            }
            acceptInitialState(getInitialState())
        }
    }

    override suspend fun acceptInitialState(initialState: State) {
        withContext(Dispatchers.IO) {
            getVortexStore()?.acceptInitialState(initialState)
        }
    }

    override suspend fun acceptLoadingState(newState: Boolean) {
        withContext(Dispatchers.IO) {
            getVortexStore()?.let {
                it.acceptLoadingState(newState)
            }
        }
    }

    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {
            getVortexStore()?.getStateObserver()?.postValue(newState)
        }
    }

    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            repo.addRequest(request)
        }
    }

    override suspend fun destroyReducer() {
        withContext(Dispatchers.IO) {
            repo.clearRepository()
            networkLister = null
        }
    }

    override suspend fun attachStateSubscriber(storeSubscriber: VortexRxStore.VortexStateListener<State>) {
        withContext(Dispatchers.IO) {
            getVortexStore()?.attachStateListener(storeSubscriber)
        }
    }

    override suspend fun getVortexStore(): VortexRxStore<State, MutableLiveData<State>>? {
        return withContext(Dispatchers.IO) {
            reducerStore.value
        }
    }

    private fun isInternetConnected(context: Context): Observable<Boolean> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo;
        return Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected);
    }

    fun executeInternetListener(context: Context) {
        repo.addRequest(
            isInternetConnected(context)
                .subscribeOn(Schedulers.io()).subscribe({
                    GlobalScope.launch {
                        when (it) {
                            true -> networkLister?.onNetworkConnected()
                            false -> networkLister?.onNetworkDisconnected()
                        }
                    }
                } , {

                })
        )
    }

    fun attachNetworkListener(networkListener: VortexNetworkListener) {
        this.networkLister = networkListener
    }

}
