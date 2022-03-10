package io.vortex.android;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 3:54 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0001\u0015J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0014\u001a\u00028\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lio/vortex/android/VortexRxStore;", "State", "Lio/vortex/android/state/VortexState;", "O", "", "acceptInitialState", "", "initState", "(Lio/vortex/android/state/VortexState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acceptLoadingState", "newState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachStateListener", "listener", "Lio/vortex/android/VortexRxStore$VortexStateListener;", "(Lio/vortex/android/VortexRxStore$VortexStateListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyStore", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentState", "getStateObserver", "VortexStateListener", "vortex_release"})
public abstract interface VortexRxStore<State extends io.vortex.android.state.VortexState, O extends java.lang.Object> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentState(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super State> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptInitialState(@org.jetbrains.annotations.NotNull()
    State initState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptLoadingState(boolean newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object destroyStore(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStateObserver(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super O> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object attachStateListener(@org.jetbrains.annotations.NotNull()
    io.vortex.android.VortexRxStore.VortexStateListener<State> listener, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lio/vortex/android/VortexRxStore$VortexStateListener;", "State", "Lio/vortex/android/state/VortexState;", "", "onStateChanged", "", "newState", "(Lio/vortex/android/state/VortexState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vortex_release"})
    public static abstract interface VortexStateListener<State extends io.vortex.android.state.VortexState> {
        
        @org.jetbrains.annotations.Nullable()
        public abstract java.lang.Object onStateChanged(@org.jetbrains.annotations.NotNull()
        State newState, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    }
}