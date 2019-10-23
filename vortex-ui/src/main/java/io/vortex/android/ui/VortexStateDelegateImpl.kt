package io.vortex.android.ui

import android.content.Context
import androidx.fragment.app.FragmentActivity
import io.vortex.android.VortexRxStore
import io.vortex.android.state.VortexState

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 11:23 AM
 */

interface VortexStateDelegateImpl<State: VortexState> {

    suspend fun commitStoreHandler(handler: VortexRxStore.VortexStateListener<State>)

    suspend fun subscribeStateHandler(context: FragmentActivity?)

    suspend fun subscribeLoadingHandler(context: FragmentActivity?)

    suspend fun unSubscribeStateHandler()

}
