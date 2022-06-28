package io.vanite.android.useCases

import io.vanite.android.models.VaniteResult
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.coroutines.CoroutineContext


typealias SimpleVaniteResult = VaniteResult<Any, Error>

/**
 * BaseUseCase is Used inside VaniteCoroutineViewModel To Communicate Between UseCases and ViewModels
 */
abstract class VaniteUseCase<in Params> : CoroutineScope, VaniteUseCaseType {

    /**
     * The Parent Job of the UseCase in this Case The Parent Job Should be the Caller
     * Inside the ViewModel
     */
    private val parentJob = SupervisorJob()

    /**
     * Everything In UseCase is Executed on Background Thread
     * By Specifing The Dispatchers.IO in the coroutineContext
     */
    private val backgroundDispatcher = Dispatchers.IO

    /**
     * This is The Listener of the State To Return it Back to ViewModel
     * In HashMap of the UseCase and it's Listener
     * That's The Channel of the UseCase
     */
    private val resultChannel = Channel<SimpleVaniteResult>()

    /**
     * This Channel is the Reciver Channel Listening to The Current Channel inside UseCase
     */
    val receiveChannel: ReceiveChannel<SimpleVaniteResult> = resultChannel

    /**
     * The Current Background Context
     */
    override val coroutineContext: CoroutineContext get() = parentJob + backgroundDispatcher

    /**
     * Run the UseCase By Calling this Method
     */
    protected abstract suspend fun run(params: Params)

    /**
     * Call this method In Case You Need To Send The Data Back to ViewModel
     */
    fun onSendState(state: SimpleVaniteResult) {
        launch {
            resultChannel.send(state)
        }
    }

    fun onSendLoadingState(isLoading: Boolean) {
        when (isLoading) {
            true -> onSendState(VaniteResult.State.Loading())
            false -> onSendState(VaniteResult.State.Loaded())
        }
    }

    /**
     * Calling the Class With it's Name to Run the UseCase
     * UseCase Method is Called in Background Thread
     */
    operator fun invoke(params: Params) {
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

    /**
     * Call This Method When The ViewModel is Destroyed
     */
    override fun clear() {
        resultChannel.close()
        parentJob.cancel()
    }

    override fun getChannelReceiveInstance(): ReceiveChannel<SimpleVaniteResult> {
        return receiveChannel
    }

}

interface VaniteUseCaseType {

    fun clear()

    fun getChannelReceiveInstance(): ReceiveChannel<SimpleVaniteResult>

}
