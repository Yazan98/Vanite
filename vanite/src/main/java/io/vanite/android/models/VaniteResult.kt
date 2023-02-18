package io.vanite.android.models


/**
 * Controlled State Result From UseCases to ViewModels
 * This State is Submitted as a State Change or as a Result From UseCase to ViewModel
 */
sealed class VaniteResult<out T, out R> {

    class Success<out T>(val successData: T) : VaniteResult<T, Nothing>()
    class Failure<out R : Error>(val errorData: R) : VaniteResult<Nothing, R>()

    class FailureResponse<out R>(val errorData: VaniteResponse<*>?) : VaniteResult<Nothing, R>()

    sealed class State : VaniteResult<Nothing, Nothing>() {
        class Loading : State()
        class Loaded : State()
    }

    fun handleResult(
        successBlock: (T) -> Unit = {},
        failureBlock: (R) -> Unit = {},
        stateBlock: (State) -> Unit = {}
    ) {
        when (this) {
            is Success -> successBlock(successData)
            is Failure -> failureBlock(errorData)
            is State -> stateBlock(this)
            else -> stateBlock(this as State)
        }
    }

    fun onResultConsumer(
        onLoadingState: (Boolean) -> Unit = {},
        onSuccessResponse: (T) -> Unit = {},
        onFailedResponse: (VaniteResponse<*>?) -> Unit = {}
    ) {
        when (this) {
            is State.Loading -> onLoadingState(true)
            is State.Loaded -> onLoadingState(false)
            is Success -> onSuccessResponse(successData)
            is FailureResponse -> onFailedResponse(errorData)
            else -> {}
        }
    }
}

/**
 * The Base Response Class Should be Child of this Type of Interface
 */
interface VaniteResponse<T>