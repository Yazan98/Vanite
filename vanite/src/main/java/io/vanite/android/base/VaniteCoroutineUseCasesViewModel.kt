package io.vanite.android.base

import androidx.annotation.CallSuper
import io.vanite.android.useCases.VaniteUseCase
import io.vanite.android.useCases.VaniteUseCaseType
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
abstract class VaniteCoroutineUseCasesViewModel : VaniteCoroutineViewModel() {

    /**
     * Clear The Jobs and Listeners of each UseCase Automaticlly
     */
    @CallSuper
    override fun onCleared() {
        getSupportedUseCases().forEach {
            it.clear()
        }
        super.onCleared()
    }

    /**
     * Save The Current UseCases Inside the ViewModel to Clear Them Automaticlly When ViewModel Destroyed
     */
    abstract fun getSupportedUseCases(): ArrayList<VaniteUseCaseType>

}