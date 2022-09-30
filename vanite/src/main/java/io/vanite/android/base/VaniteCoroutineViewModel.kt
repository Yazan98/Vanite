package io.vanite.android.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.vanite.android.models.VaniteResult
import io.vanite.android.useCases.VaniteUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach


/**
 * This Type of ViewModels Used with Jetpack Compose and UseCases
 * This is Implemented like this because it's ready to be configured with Hilt Constructor Injection
 */
@ObsoleteCoroutinesApi
abstract class VaniteCoroutineViewModel : ViewModel(), CoroutineScope {

    /**
     * Current Executed job In ViewModel
     * Used to Manage The Background Tasks on the Same Job
     */
    private val currentJob = Job()

    /**
     * The Current Coroutine Context Used inside ViewModel
     * Needed Because ViewModelScope By Default Working on Main Thread
     */
    override val coroutineContext = currentJob + Dispatchers.IO

    /**
     * HashMap of Channels in ViewModel because The ViewModel Maybe Has More Than one Steaming Channel
     * And More than One Use Case So we Keep Them inside HashMap of the Channel Key and the Value of the Steam
     * HashMap<The Caller Name, the Listener>
     */
    private val receiveChannel: HashMap<String, ReceiveChannel<VaniteResult<Any, Error>>> by lazy { HashMap() }

    /**
     * Initialize the ViewModel Streaming Listeners for Each UseCase
     * Now We Run Consumers to Collect the Data From Each Channel and Return it to Sub ViewModel
     */
    fun initViewModel() {
        for ((key, value) in getListeners()) {
            receiveChannel[key] = value
        }

        for ((key, value) in receiveChannel) {
            launch {
                value.consumeEach {
                    onListenerTriggered(key, it)
                }
            }
        }
    }

    /**
     * Each ViewModel Should Implement This Method and return a HashMap
     * of the Supported Listeners for Each UseCase inside the ViewModel
     */
    abstract fun getListeners(): HashMap<String, ReceiveChannel<VaniteResult<Any, Error>>>

    /**
     * This Method is Triggered When UseCases Submit the State or Result To Return it Back to ViewModel
     * Like Loading, Error, Data
     */
    abstract fun onListenerTriggered(key: String, value: VaniteResult<Any, Error>)

    /**
     * Remove The Instances and listeners when Destroy the ViewModel
     */
    override fun onCleared() {
        receiveChannel.values.forEach {
            it.cancel()
        }
        receiveChannel.clear()
        coroutineContext.cancel()
        super.onCleared()
    }

}