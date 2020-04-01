package io.vortex.android.reducer

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vortex.android.rx.VortexRxRepository

abstract class VortexPureViewModel : ViewModel(), VortexPureViewModelImpl {

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
