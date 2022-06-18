package io.vanite.android.base

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.vanite.android.VaniteAction
import io.vanite.android.VaniteNetworkListener
import io.vanite.android.VaniteRxReducer
import io.vanite.android.VaniteViewModelType
import io.vanite.android.rx.VaniteRxRepository
import io.vanite.android.state.VaniteLoadingState
import io.vanite.android.state.VaniteState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:32 AM
 */

/**
 * VaniteViewModel is the initial point at application logic
 * this class should always notify the View about his state because (The View) at application don't know abything
 * about application just apply the incoming state from ViewModel To View
 *
 * Supported Views -> (Activity , Fragment)
 *
 * @param State : This Param is The Current State About The ViewModel Like THis
 * AuthState -> (SuccessAuthState , ErrorAuthState , LoadingAuthState , EmptyAuthState , BlockedAuthState)
 * and you should at this type of viewModel handle each state at stateObserver using acceptNewState()
 *
 * @param Action : This Action is Really Important because The View can just do Two Things
 * 1. Apply The Last State At ViewModel
 * 2. Submit View Actions From User To ViewModel
 *
 * Examples:
 * AuthRegisterAction should send the User Information To ViewModel To Execute The Register Steps
 * AuthLoginAction Should send The Auth Information (Email , Password) To ViewModel Via Action
 *
 * Each Method At ViewModel executed On Background Thread And The View Handler Should Apply The Result On Main Thread
 */
abstract class VaniteViewModel<State : VaniteState, Action : VaniteAction> : ViewModel(),
    VaniteRxReducer<State, Action>, VaniteViewModelType {

    /**
     * This State Here is to notify the view that you should start show loading to the user
     * and hide the content of the screen
     *
     * Here you should implement onLoadingStateListener that provide you the viewModel status
     */
    private val loadingState: MutableLiveData<VaniteLoadingState> by lazy {
        MutableLiveData<VaniteLoadingState>()
    }

    /**
     * EffectHandler is a Listener Used To Return a Effect From ViewModel to UI
     * After Submitting a Logic and Want to Send an Effect to the UI but in case of this Effect is not a State
     * Use This Listener
     */
    private val effectState: VaniteSingleLiveData<Any> by lazy {
        VaniteSingleLiveData()
    }

    /**
     * At each screen there are an important content and you should save the state to handle it
     *
     * when view is destroyed and reCreate the new content and for this case
     * this LiveData (StateObserver) this should always notify view at last saved state
     *
     * this state is just when you want to save one type of state like user model
     */
    private val stateObserver: MutableLiveData<State> by lazy {
        MutableLiveData<State>()
    }

    /**
     * This Listener is Used When You Apply The Network Observable To Activate
     * Realtime Network Listener And Handle The Result To Listener
     *
     * THis Case using just for Application using Internet At Each Screen With Realtime Operations
     */
    private var networkLister: VaniteNetworkListener? = null

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
     * This Method Should Handle a Effects On the UI but this Effects is Not A State
     */
    override suspend fun acceptEffectHandlerState(newEffect: Any) {
        withContext(Dispatchers.IO) {
            effectState.postValue(newEffect)
        }
    }

    /**
     * This Method Should Handle The Initial State To View
     * Each ViewModel Has an Initial State that initiate the View Before Anything Shown At View
     */
    override suspend fun acceptInitialState(initialState: State) {
        withContext(Dispatchers.IO) {
            stateObserver.postValue(getInitialState())
        }
    }

    /**
     * This Method Should Notify The View to Change The Loading State
     */
    override suspend fun acceptLoadingState(newState: Boolean) {
        withContext(Dispatchers.IO) {
            loadingState.postValue(VaniteLoadingState(newState))
        }
    }

    /**
     * THis Method is The Important Method At ViewModel because you can control the View State from here
     * Here you can apply The New State To View Like Examples At Header of the Class
     */
    override suspend fun acceptNewState(newState: State) {
        withContext(Dispatchers.IO) {
            stateObserver.postValue(newState)
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

    /**
     * You can call this Method at 2 Ways
     * 1. OnDestroy
     * 2. OnClear
     *
     * To Delete All Requests , Listeners
     */
    override suspend fun destroyViewModel() {
        withContext(Dispatchers.IO) {
            repo.clearRepository()
            networkLister = null
        }
    }

    private fun isInternetConnected(context: Context): Observable<Boolean> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo;
        return Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected);
    }

    fun executeInternetListener(context: Context) {
        repo.addRequest(
            isInternetConnected(context)
                .subscribeOn(Schedulers.io()).subscribe({
                    when (it) {
                        true -> networkLister?.onNetworkConnected()
                        false -> networkLister?.onNetworkDisconnected()
                    }
                }, {

                })
        )
    }

    fun getStateHandler(): MutableLiveData<State> {
        return stateObserver
    }

    fun getEffectStateHandler(): VaniteSingleLiveData<Any> {
        return effectState
    }

    fun getLoadingStateHandler(): MutableLiveData<VaniteLoadingState> {
        return loadingState
    }

    fun attachNetworkListener(networkListener: VaniteNetworkListener) {
        this.networkLister = networkListener
    }

    fun getRxRepository(): VaniteRxRepository {
        return repo
    }


    /**
     * THis is the Default OnSuccess Senario when The Response is Success Result you should stop the Loader
     * and apply the new State
     */
    suspend fun handleStateWithLoading(state: State) {
        withContext(Dispatchers.IO) {
            stateObserver.postValue(state)
            loadingState.postValue(VaniteLoadingState(false))
        }
    }

    private fun destroyListeners() {
        repo.clearRepository()
        networkLister = null
    }

    override fun onCleared() {
        destroyListeners()
        super.onCleared()
    }

}
