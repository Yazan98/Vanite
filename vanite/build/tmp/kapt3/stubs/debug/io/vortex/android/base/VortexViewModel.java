package io.vortex.android.base;

import java.lang.System;

/**
 * VortexViewModel is the initial point at application logic
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
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u000e\u0010\'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0011J\b\u0010)\u001a\u00020\u001bH\u0002J\u0011\u0010*\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u00100\u001a\u00020\u0013J\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ\u0019\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020 052\u0006\u0010-\u001a\u00020.H\u0002J\b\u00106\u001a\u00020\u001bH\u0014R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0018\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lio/vortex/android/base/VortexViewModel;", "State", "Lio/vortex/android/state/VortexState;", "Action", "Lio/vortex/android/VortexAction;", "Landroidx/lifecycle/ViewModel;", "Lio/vortex/android/VortexRxReducer;", "Lio/vortex/android/VortexViewModelType;", "()V", "loadingState", "Landroidx/lifecycle/MutableLiveData;", "Lio/vortex/android/state/VortexLoadingState;", "getLoadingState", "()Landroidx/lifecycle/MutableLiveData;", "loadingState$delegate", "Lkotlin/Lazy;", "networkLister", "Lio/vortex/android/VortexNetworkListener;", "repo", "Lio/vortex/android/rx/VortexRxRepository;", "getRepo", "()Lio/vortex/android/rx/VortexRxRepository;", "repo$delegate", "stateObserver", "getStateObserver", "stateObserver$delegate", "acceptInitialState", "", "initialState", "(Lio/vortex/android/state/VortexState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptLoadingState", "newState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptNewState", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachNetworkListener", "networkListener", "destroyListeners", "destroyViewModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeInternetListener", "context", "Landroid/content/Context;", "getLoadingStateHandler", "getRxRepository", "getStateHandler", "handleStateWithLoading", "state", "isInternetConnected", "Lio/reactivex/Observable;", "onCleared", "vortex_debug"})
public abstract class VortexViewModel<State extends io.vortex.android.state.VortexState, Action extends io.vortex.android.VortexAction> extends androidx.lifecycle.ViewModel implements io.vortex.android.VortexRxReducer<State, Action>, io.vortex.android.VortexViewModelType {
    
    /**
     * This State Here is to notify the view that you should start show loading to the user
     * and hide the content of the screen
     *
     * Here you should implement onLoadingStateListener that provide you the viewModel status
     */
    private final kotlin.Lazy loadingState$delegate = null;
    
    /**
     * At each screen there are an important content and you should save the state to handle it
     *
     * when view is destroyed and reCreate the new content and for this case
     * this LiveData (StateObserver) this should always notify view at last saved state
     *
     * this state is just when you want to save one type of state like user model
     */
    private final kotlin.Lazy stateObserver$delegate = null;
    
    /**
     * This Listener is Used When You Apply The Network Observable To Activate
     * Realtime Network Listener And Handle The Result To Listener
     *
     * THis Case using just for Application using Internet At Each Screen With Realtime Operations
     */
    private io.vortex.android.VortexNetworkListener networkLister;
    
    /**
     * At Data Layer THere are An Observables Each Observable always listening to The Target
     * And This Repository should implement Disposable (The Subscribe Result) To Manage THem
     * and Clear Them When View is Destroyed and no ways to back to this View
     *
     * At This Case Observable is not important anymore and should UnSubscribe Them
     */
    private final kotlin.Lazy repo$delegate = null;
    
    public VortexViewModel() {
        super();
    }
    
    /**
     * This State Here is to notify the view that you should start show loading to the user
     * and hide the content of the screen
     *
     * Here you should implement onLoadingStateListener that provide you the viewModel status
     */
    private final androidx.lifecycle.MutableLiveData<io.vortex.android.state.VortexLoadingState> getLoadingState() {
        return null;
    }
    
    /**
     * At each screen there are an important content and you should save the state to handle it
     *
     * when view is destroyed and reCreate the new content and for this case
     * this LiveData (StateObserver) this should always notify view at last saved state
     *
     * this state is just when you want to save one type of state like user model
     */
    private final androidx.lifecycle.MutableLiveData<State> getStateObserver() {
        return null;
    }
    
    /**
     * At Data Layer THere are An Observables Each Observable always listening to The Target
     * And This Repository should implement Disposable (The Subscribe Result) To Manage THem
     * and Clear Them When View is Destroyed and no ways to back to this View
     *
     * At This Case Observable is not important anymore and should UnSubscribe Them
     */
    private final io.vortex.android.rx.VortexRxRepository getRepo() {
        return null;
    }
    
    /**
     * This Method Should Handle The Initial State To View
     * Each ViewModel Has an Initial State that initiate the View Before Anything Shown At View
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptInitialState(@org.jetbrains.annotations.NotNull()
    State initialState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * This Method Should Notify The View to Change The Loading State
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptLoadingState(boolean newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * THis Method is The Important Method At ViewModel because you can control the View State from here
     * Here you can apply The New State To View Like Examples At Header of the Class
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptNewState(@org.jetbrains.annotations.NotNull()
    State newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * When you get (Observable , Flowable , Single , etc)
     * The Object is Always Listening to The Target and you should
     * UnSubscribe them when you don't need to use Them and this method
     * just to add the result of the Subscriber At RxJava 2 to manage them At ViewModel LifeCycle
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * You can call this Method at 2 Ways
     * 1. OnDestroy
     * 2. OnClear
     *
     * To Delete All Requests , Listeners
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object destroyViewModel(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final io.reactivex.Observable<java.lang.Boolean> isInternetConnected(android.content.Context context) {
        return null;
    }
    
    public final void executeInternetListener(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<State> getStateHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<io.vortex.android.state.VortexLoadingState> getLoadingStateHandler() {
        return null;
    }
    
    public final void attachNetworkListener(@org.jetbrains.annotations.NotNull()
    io.vortex.android.VortexNetworkListener networkListener) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.vortex.android.rx.VortexRxRepository getRxRepository() {
        return null;
    }
    
    /**
     * THis is the Default OnSuccess Senario when The Response is Success Result you should stop the Loader
     * and apply the new State
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object handleStateWithLoading(@org.jetbrains.annotations.NotNull()
    State state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void destroyListeners() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}