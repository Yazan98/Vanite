package io.vanite.android.compose.logic


import io.vanite.android.compose.VaniteApplicationState
import kotlinx.coroutines.channels.ReceiveChannel

interface VaniteUseCaseType<Result> {

    fun clear()

    fun getChannelListener(): ReceiveChannel<VaniteApplicationState<Result>>

    fun getUseCaseKey(): String

}