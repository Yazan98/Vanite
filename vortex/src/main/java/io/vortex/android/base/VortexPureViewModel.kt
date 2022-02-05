package io.vortex.android.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vortex.android.VortexViewModelType
import io.vortex.android.rx.VortexRxRepository

/**
 * This ViewModel Type Used To Handle Api's Without Any State Saved or The State Will be Managed
 * By The Sub Class
 *
 * This ViewModel Only Managed VortexRxRepository With RxJava Requests
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
abstract class VortexPureViewModel : ViewModel(), VortexPureViewModelImpl, VortexViewModelType {

    private val repository: VortexRxRepository by lazy {
        VortexRxRepository()
    }

    override fun getRxRepository(): VortexRxRepository {
        return repository
    }

    override fun addRxRequest(request: Disposable) {
        getRxRepository().addRequest(request)
    }

    override fun onCleared() {
        getRxRepository().clearRepository()
        super.onCleared()
    }

}

interface VortexPureViewModelImpl {

    fun getRxRepository(): VortexRxRepository

    fun addRxRequest(request: Disposable)

}
