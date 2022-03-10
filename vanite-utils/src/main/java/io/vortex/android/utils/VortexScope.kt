package io.vortex.android.utils

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class VortexScope : CoroutineScope {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    fun destroyScope() {
        scope.cancel()
    }

    fun destroyScope(error: CancellationException) {
        scope.cancel(error)
    }

}