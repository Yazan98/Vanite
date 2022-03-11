package io.vanite.android.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vanite.android.VaniteViewModelType
import io.vanite.android.rx.VaniteRxRepository

/**
 * This ViewModel Type Used To Handle Api's Without Any State Saved or The State Will be Managed
 * By The Sub Class
 *
 * This ViewModel Only Managed VaniteRxRepository With RxJava Requests
 * Note: Full Implementation of An Vanite ViewModel With State, Action, RxJava is Available at @see VaniteViewModel
 */
abstract class VanitePureViewModel : ViewModel(), VanitePureViewModelImpl, VaniteViewModelType {

    private val repository: VaniteRxRepository by lazy {
        VaniteRxRepository()
    }

    override fun getRxRepository(): VaniteRxRepository {
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

interface VanitePureViewModelImpl {

    fun getRxRepository(): VaniteRxRepository

    fun addRxRequest(request: Disposable)

}
