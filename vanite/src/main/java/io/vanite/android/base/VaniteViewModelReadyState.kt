package io.vanite.android.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.vanite.android.VaniteModelStateImpl
import io.vanite.android.VaniteViewModelType
import io.vanite.android.keys.VaniteViewModelState
import io.vanite.android.rx.VaniteRxRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * This ViewModel Type Used When You want to Build ViewModel Without Passing Specific State to it
 * this one can handle Any State that Extends VaniteViewModelState in the Application
 * This Will Reduce A lot of Classes if you want to Build ViewModel For Each State
 * One Can Handle all Stats
 *
 * Note: Full Implementation of An Vanite ViewModel With State, Action, RxJava is Available at @see VaniteViewModel
 */
abstract class VaniteViewModelReadyState : ViewModel(), VaniteModelStateImpl, VaniteViewModelType {

    /**
     * State Handler Type
     * This Type is Hardcoded Types of State at the ViewModel
     * Use This Type Of ViewModel State When You Just Want THis Kind Of State Implementation
     * Without that Hard Logic When You Reflect The Data From ViewModel To View
     *
     * Vanite Default State Handler you must declare each State With Response Type, Items
     * And You can Send The Result via State to View
     * that's th problem you always creating new Class For Each State Handling
     * but we can just use this kind of State Handler with Common logic at each Screen
     * THe Common cases at each screen -> {LOADING, EMPTY, SUCCESS, ERROR}
     */
    private val state: MutableLiveData<VaniteViewModelState> by lazy {
        MutableLiveData<VaniteViewModelState>()
    }

    /**
     * At Data Layer THere are An Observables Each Observable always listening to The Target
     * And This Repository should implement Disposable (The Subscribe Result) To Manage THem
     * and Clear Them When View is Destroyed and no ways to back to this View
     *
     * At This Case Observable is not important anymore and should UnSubscribe Them
     */
    private val repo: VaniteRxRepository by lazy {
        VaniteRxRepository()
    }

    /**
     * Here you can easily send a new state to View With The Following Provided State
     * The Available States -> {LOADING, ERROR, SUCCESS, EMPTY}
     */
    override suspend fun acceptNewState(newState: VaniteViewModelState) {
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

    override fun getRepositoryHandler(): VaniteRxRepository {
        return repo
    }

    override fun getCurrentViewModelState(): VaniteViewModelState? {
        return state.value
    }

    override fun getStateHandler(): MutableLiveData<VaniteViewModelState> {
        return state
    }

}
