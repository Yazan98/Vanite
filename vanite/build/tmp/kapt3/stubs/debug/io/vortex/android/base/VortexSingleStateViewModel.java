package io.vortex.android.base;

import java.lang.System;

/**
 * This ViewModel Used To Create ViewModel With Only State, Without Actions To ViewModel
 * Not Recommended To Use But It's Option Available in Vortex
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\b\u0010&\u001a\u00020\u0019H\u0014R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lio/vortex/android/base/VortexSingleStateViewModel;", "State", "Lio/vortex/android/state/VortexState;", "Landroidx/lifecycle/ViewModel;", "Lio/vortex/android/VortexSingleStateViewModelImpl;", "Lio/vortex/android/VortexViewModelType;", "()V", "loadingState", "Landroidx/lifecycle/MutableLiveData;", "Lio/vortex/android/state/VortexLoadingState;", "getLoadingState", "()Landroidx/lifecycle/MutableLiveData;", "loadingState$delegate", "Lkotlin/Lazy;", "repository", "Lio/vortex/android/rx/VortexRxRepository;", "getRepository", "()Lio/vortex/android/rx/VortexRxRepository;", "repository$delegate", "state", "Landroidx/lifecycle/MediatorLiveData;", "getState", "()Landroidx/lifecycle/MediatorLiveData;", "state$delegate", "acceptLoadingState", "", "newState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptNewState", "(Lio/vortex/android/state/VortexState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoadingStateHandler", "getRxRepository", "getStateHandler", "onCleared", "vortex_debug"})
public abstract class VortexSingleStateViewModel<State extends io.vortex.android.state.VortexState> extends androidx.lifecycle.ViewModel implements io.vortex.android.VortexSingleStateViewModelImpl<State>, io.vortex.android.VortexViewModelType {
    private final kotlin.Lazy state$delegate = null;
    private final kotlin.Lazy repository$delegate = null;
    private final kotlin.Lazy loadingState$delegate = null;
    
    public VortexSingleStateViewModel() {
        super();
    }
    
    private final androidx.lifecycle.MediatorLiveData<State> getState() {
        return null;
    }
    
    private final io.vortex.android.rx.VortexRxRepository getRepository() {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<io.vortex.android.state.VortexLoadingState> getLoadingState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptNewState(@org.jetbrains.annotations.NotNull()
    State newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptLoadingState(boolean newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<State> getStateHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<io.vortex.android.state.VortexLoadingState> getLoadingStateHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.vortex.android.rx.VortexRxRepository getRxRepository() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}