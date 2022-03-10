package io.vortex.android;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:47 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lio/vortex/android/VortexRxReducer;", "State", "Lio/vortex/android/state/VortexState;", "Action", "Lio/vortex/android/VortexAction;", "", "acceptInitialState", "", "initialState", "(Lio/vortex/android/state/VortexState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptLoadingState", "newState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptNewState", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyViewModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "newAction", "(Lio/vortex/android/VortexAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInitialState", "vortex_debug"})
public abstract interface VortexRxReducer<State extends io.vortex.android.state.VortexState, Action extends io.vortex.android.VortexAction> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    Action newAction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptInitialState(@org.jetbrains.annotations.NotNull()
    State initialState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptLoadingState(boolean newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInitialState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super State> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptNewState(@org.jetbrains.annotations.NotNull()
    State newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object destroyViewModel(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}