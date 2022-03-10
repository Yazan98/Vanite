package io.vortex.android;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&J\b\u0010\u0015\u001a\u00020\u0016H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lio/vortex/android/VortexSingleStateViewModelImpl;", "State", "Lio/vortex/android/state/VortexState;", "", "acceptLoadingState", "", "newState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptNewState", "(Lio/vortex/android/state/VortexState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "newAction", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoadingStateHandler", "Landroidx/lifecycle/MutableLiveData;", "Lio/vortex/android/state/VortexLoadingState;", "getRxRepository", "Lio/vortex/android/rx/VortexRxRepository;", "getStateHandler", "vortex_release"})
public abstract interface VortexSingleStateViewModelImpl<State extends io.vortex.android.state.VortexState> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    java.lang.Object newAction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptNewState(@org.jetbrains.annotations.NotNull()
    State newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptLoadingState(boolean newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.MutableLiveData<State> getStateHandler();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.MutableLiveData<io.vortex.android.state.VortexLoadingState> getLoadingStateHandler();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.vortex.android.rx.VortexRxRepository getRxRepository();
}