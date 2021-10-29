package io.vortex.android.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vortex.android.VortexModelStateImpl
import io.vortex.android.keys.VortexViewModelState
import io.vortex.android.rx.VortexRxRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class VortexViewModelReadyState : ViewModel(), VortexModelStateImpl {

    /**
     * State Handler Type
     * This Type is Hardcoded Types of State at the ViewModel
     * Use This Type Of ViewModel State When You Just Want THis Kind Of State Implementation
     * Without that Hard Logic When You Reflect The Data From ViewModel To View
     *
     * Vortex Default State Handler you must declare each State With Response Type, Items
     * And You can Send The Result via State to View
     * that's th problem you always creating new Class For Each State Handling
     * but we can just use this kind of State Handler with Common logic at each Screen
     * THe Common cases at each screen -> {LOADING, EMPTY, SUCCESS, ERROR}
     */
    private val state: MutableLiveData<VortexViewModelState> by lazy {
        MutableLiveData<VortexViewModelState>()
    }

    /**
     * At Data Layer THere are An Observables Each Observable always listening to The Target
     * And This Repository should implement Disposable (The Subscribe Result) To Manage THem
     * and Clear Them When View is Destroyed and no ways to back to this View
     *
     * At This Case Observable is not important anymore and should UnSubscribe Them
     */
    private val repo: VortexRxRepository by lazy {
        VortexRxRepository()
    }

    /**
     * Here you can easily send a new state to View With The Following Provided State
     * The Available States -> {LOADING, ERROR, SUCCESS, EMPTY}
     */
    override suspend fun acceptNewState(newState: VortexViewModelState) {
        withContext(Dispatchers.IO) {
            state.postValue(newState)
        }
    }

    /**
     * When you get (Observable , Flowable , Single , etc)
     * The Object is Always Listening to The Target and you should
     * UnSubscribe them when you don't need to use Them and this method
     * just to add the result of the Subscriber At RxJava 2 to manage them At ViewModel LifeCycle
     */
    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            repo.addRequest(request)
        }
    }

    override fun getRepositoryHandler(): VortexRxRepository {
        return repo
    }

    override fun getCurrentViewModelState(): VortexViewModelState? {
        return state.value
    }

    override fun getStateHandler(): MutableLiveData<VortexViewModelState> {
        return state
    }

}
