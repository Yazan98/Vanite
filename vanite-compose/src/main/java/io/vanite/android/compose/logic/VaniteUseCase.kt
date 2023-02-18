package io.vanite.android.compose.logic


import io.vanite.android.compose.VaniteApplicationState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class VaniteUseCase<Arguments, Result>: CoroutineScope, VaniteUseCaseType<Result> {

    private val parentJob = SupervisorJob()
    private val backgroundDispatcher = Dispatchers.IO
    private val resultChannel: Channel<VaniteApplicationState<Result>> by lazy { Channel() }
    private val receiveChannel: ReceiveChannel<VaniteApplicationState<Result>> by lazy { resultChannel }

    override val coroutineContext: CoroutineContext
        get() = parentJob + backgroundDispatcher

    override fun getChannelListener(): ReceiveChannel<VaniteApplicationState<Result>> {
        return this.receiveChannel
    }

    protected fun onSendState(state: VaniteApplicationState<Result>) {
        launch {
            resultChannel.send(state)
        }
    }

    protected fun onSendLoadingState(isLoading: Boolean) {
        when (isLoading) {
            true -> onSendState(VaniteApplicationState.Loading)
            false -> onSendState(VaniteApplicationState.Loaded)
        }
    }

    override fun clear() {
        this.resultChannel.close()
        parentJob.cancel()
    }

    protected abstract fun run(args: Arguments)

    /**
     * Calling the Class With it's Name to Run the UseCase
     * UseCase Method is Called in Background Thread
     */
    operator fun invoke(params: Arguments) {
        launch {
            withContext(backgroundDispatcher) {
                run(params)
            }
        }
    }

    /**
     * Start Async Jobs Inside Each UseCase to Not Blocking the Current Thread
     */
    protected fun <T> startAsync(block: suspend () -> T): Deferred<T> = async(parentJob) {
        block()
    }

}