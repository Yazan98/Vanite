package io.vortex.android.reducer.multi

import androidx.lifecycle.LiveData
import io.vortex.android.VortexAction
import io.vortex.android.VortexViewExecutorImpl
import io.vortex.android.state.VortexState

class VortexViewExecutor<State: VortexState, Action: VortexAction>: VortexViewExecutorImpl<State, Action> {

    override suspend fun createState(state: State, tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSourceByTag(tag: String): LiveData<State> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun destroyAllStates() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun destroyStateByTag(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
