package io.vanite.android.models

/**
 * Controlled State Result From UseCases to ViewModels
 * This State is Submitted as a State Change or as a Result From UseCase to ViewModel
 */
sealed class VaniteResult<out T, out R> {

    class Success<out T>(val successData: T) : VaniteResult<T, Nothing>()
    class Failure<out R : Error>(val errorData: R) : VaniteResult<Nothing, R>()

    sealed class State : VaniteResult<Nothing, Nothing>() {
        class Loading : State()
        class Loaded : State()
    }

    fun handleResult(successBlock: (T) -> Unit = {}, failureBlock: (R) -> Unit = {}, stateBlock: (State) -> Unit = {}) {
        when (this) {
            is Success -> successBlock(successData)
            is Failure -> failureBlock(errorData)
            is State -> stateBlock(this)
        }
    }
}
