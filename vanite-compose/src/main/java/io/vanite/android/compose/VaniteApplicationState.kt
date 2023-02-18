package io.vanite.android.compose

sealed class VaniteApplicationState<out T> {
    data class Success<out T : Any>(
        val data: T?
    ) : VaniteApplicationState<T>()

    object Loading: VaniteApplicationState<Nothing>()
    object Loaded: VaniteApplicationState<Nothing>()

    data class Error(
        val exception: Throwable? = null,
        val responseCode: Int = -1
    ) : VaniteApplicationState<Nothing>()

    fun handleResult(onSuccess: ((responseData: T?) -> Unit)?, onError: ((error: Error) -> Unit)?, onLoading: ((loadingState: Boolean) -> Unit)? = null) {
        when (this) {
            is Success -> {
                onSuccess?.invoke(this.data)
            }
            is Error -> {
                onError?.invoke(this)
            }
            is Loading -> {
                onLoading?.invoke(true)
            }
            is Loaded -> {
                onLoading?.invoke(false)
            }
        }
    }
}