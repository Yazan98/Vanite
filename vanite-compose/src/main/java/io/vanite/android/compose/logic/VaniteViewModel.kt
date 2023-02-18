package io.vanite.android.compose.logic


import android.text.TextUtils
import androidx.compose.runtime.mutableStateOf
import io.vanite.android.compose.props.VaniteAction
import io.vanite.android.compose.props.VaniteState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


abstract class VaniteViewModel<Action: VaniteAction, State: VaniteState>: VaniteBaseViewModel<Action, State, MutableStateFlow<State>>() {

    val errorMessageListener by lazy { mutableStateOf("") }
    val errorScreenListener by lazy { mutableStateOf<Throwable?>(null) }

    override fun initializeViewModel() {
        super.initializeViewModel()
        if (state == null) {
            state = MutableStateFlow(getInitialState())
        }

        scope.launch(Dispatchers.IO) {
            state?.collect {
                onNewStateTriggered(it)
            }
        }
    }

    protected fun onAcceptNewState(newState: State) {
        scope.launch(Dispatchers.IO) {
            state?.update { newState }
        }
    }

    override fun getCurrentState(): State? {
        return state?.value
    }

}