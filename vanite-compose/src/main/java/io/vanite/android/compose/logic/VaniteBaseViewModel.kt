package io.vanite.android.compose.logic


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.vanite.android.compose.VaniteApplicationState
import io.vanite.android.compose.props.VaniteAction
import io.vanite.android.compose.props.VaniteEither
import io.vanite.android.compose.props.VaniteState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch


abstract class VaniteBaseViewModel<Action: VaniteAction, State: VaniteState, StateType>: ViewModel() {

    protected val scope: CoroutineScope = viewModelScope
    protected var state: StateType? = null

    open fun initializeViewModel() {
        getSupportedUseCases().forEach { useCase ->
            scope.launch(Dispatchers.IO) {
                useCase.getChannelListener().consumeEach {
                    scope.launch(Dispatchers.Main) {
                        onListenerTriggered(useCase.getUseCaseKey(),
                            it as VaniteApplicationState<Any>
                        )
                    }
                }
            }
        }
    }

    private fun clear(): VaniteEither<Boolean, Exception> {
        return try {
            scope.cancel()
            getSupportedUseCases().forEach {
                it.clear()
            }

            VaniteEither(true, null)
        } catch (ex: Exception) {
            VaniteEither(null, ex)
        }
    }

    override fun onCleared() {
        val state = clear()
        state.onStateTriggered {
            println("ViewModel State Cleared Success")
        }

        state.onSecondStateTriggered {
            println("ViewModel State Failed to Clear With Exception : ${it.message}")
        }
        super.onCleared()
    }

    open fun getCurrentState(): State? {
        return this.state as? State
    }

    open fun onNewStateTriggered(newState: State) = Unit

    abstract fun executeAction(action: Action)

    abstract fun getInitialState(): State

    abstract fun onListenerTriggered(key: String, value: VaniteApplicationState<Any>)

    abstract fun getSupportedUseCases(): ArrayList<VaniteUseCaseType<*>>

}