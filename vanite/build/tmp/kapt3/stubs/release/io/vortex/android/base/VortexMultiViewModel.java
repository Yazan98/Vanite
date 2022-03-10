package io.vortex.android.base;

import java.lang.System;

/**
 * This ViewModel Used When You Want to add Multiple MutableLiveData Inside MediatorLiveData
 * The Current State Will be MediatorLiveData To Hold More Than One State Per Screen
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J\b\u0010(\u001a\u00020\u001bH\u0014R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lio/vortex/android/base/VortexMultiViewModel;", "State", "Lio/vortex/android/state/VortexState;", "Action", "Lio/vortex/android/VortexAction;", "Landroidx/lifecycle/ViewModel;", "Lio/vortex/android/VortexMultiViewModelImpl;", "Lio/vortex/android/VortexViewModelType;", "()V", "loadingState", "Landroidx/lifecycle/MutableLiveData;", "Lio/vortex/android/state/VortexLoadingState;", "getLoadingState", "()Landroidx/lifecycle/MutableLiveData;", "loadingState$delegate", "Lkotlin/Lazy;", "repository", "Lio/vortex/android/rx/VortexRxRepository;", "getRepository", "()Lio/vortex/android/rx/VortexRxRepository;", "repository$delegate", "state", "Landroidx/lifecycle/MediatorLiveData;", "getState", "()Landroidx/lifecycle/MediatorLiveData;", "state$delegate", "acceptLoadingState", "", "newState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptNewState", "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyViewModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "vortex_release"})
public abstract class VortexMultiViewModel<State extends io.vortex.android.state.VortexState, Action extends io.vortex.android.VortexAction> extends androidx.lifecycle.ViewModel implements io.vortex.android.VortexMultiViewModelImpl<State, Action>, io.vortex.android.VortexViewModelType {
    private final kotlin.Lazy state$delegate = null;
    private final kotlin.Lazy repository$delegate = null;
    private final kotlin.Lazy loadingState$delegate = null;
    
    public VortexMultiViewModel() {
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
    androidx.lifecycle.LiveData<State> newState, @org.jetbrains.annotations.NotNull()
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
    public java.lang.Object getLoadingState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.lifecycle.MutableLiveData<io.vortex.android.state.VortexLoadingState>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.lifecycle.LiveData<State>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object destroyViewModel(@org.jetbrains.annotations.NotNull()
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
    
    @java.lang.Override()
    protected void onCleared() {
    }
}