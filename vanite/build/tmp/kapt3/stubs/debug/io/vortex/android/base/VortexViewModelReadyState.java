package io.vortex.android.base;

import java.lang.System;

/**
 * This ViewModel Type Used When You want to Build ViewModel Without Passing Specific State to it
 * this one can handle Any State that Extends VortexViewModelState in the Application
 * This Will Reduce A lot of Classes if you want to Build ViewModel For Each State
 * One Can Handle all Stats
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\n\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lio/vortex/android/base/VortexViewModelReadyState;", "Landroidx/lifecycle/ViewModel;", "Lio/vortex/android/VortexModelStateImpl;", "Lio/vortex/android/VortexViewModelType;", "()V", "repo", "Lio/vortex/android/rx/VortexRxRepository;", "getRepo", "()Lio/vortex/android/rx/VortexRxRepository;", "repo$delegate", "Lkotlin/Lazy;", "state", "Landroidx/lifecycle/MutableLiveData;", "Lio/vortex/android/keys/VortexViewModelState;", "getState", "()Landroidx/lifecycle/MutableLiveData;", "state$delegate", "acceptNewState", "", "newState", "(Lio/vortex/android/keys/VortexViewModelState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentViewModelState", "getRepositoryHandler", "getStateHandler", "vortex_debug"})
public abstract class VortexViewModelReadyState extends androidx.lifecycle.ViewModel implements io.vortex.android.VortexModelStateImpl, io.vortex.android.VortexViewModelType {
    
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
    private final kotlin.Lazy state$delegate = null;
    
    /**
     * At Data Layer THere are An Observables Each Observable always listening to The Target
     * And This Repository should implement Disposable (The Subscribe Result) To Manage THem
     * and Clear Them When View is Destroyed and no ways to back to this View
     *
     * At This Case Observable is not important anymore and should UnSubscribe Them
     */
    private final kotlin.Lazy repo$delegate = null;
    
    public VortexViewModelReadyState() {
        super();
    }
    
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
    private final androidx.lifecycle.MutableLiveData<io.vortex.android.keys.VortexViewModelState> getState() {
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
     * Here you can easily send a new state to View With The Following Provided State
     * The Available States -> {LOADING, ERROR, SUCCESS, EMPTY}
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptNewState(@org.jetbrains.annotations.NotNull()
    io.vortex.android.keys.VortexViewModelState newState, @org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.vortex.android.rx.VortexRxRepository getRepositoryHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.vortex.android.keys.VortexViewModelState getCurrentViewModelState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<io.vortex.android.keys.VortexViewModelState> getStateHandler() {
        return null;
    }
}