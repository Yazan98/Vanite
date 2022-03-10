package io.vortex.android;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000f\u001a\u00020\u0010H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lio/vortex/android/VortexModelStateImpl;", "", "acceptNewState", "", "newState", "Lio/vortex/android/keys/VortexViewModelState;", "(Lio/vortex/android/keys/VortexViewModelState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRxRequest", "request", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "newAction", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentViewModelState", "getRepositoryHandler", "Lio/vortex/android/rx/VortexRxRepository;", "getStateHandler", "Landroidx/lifecycle/MutableLiveData;", "vortex_debug"})
public abstract interface VortexModelStateImpl {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object acceptNewState(@org.jetbrains.annotations.NotNull()
    io.vortex.android.keys.VortexViewModelState newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.MutableLiveData<io.vortex.android.keys.VortexViewModelState> getStateHandler();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.vortex.android.rx.VortexRxRepository getRepositoryHandler();
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.vortex.android.keys.VortexViewModelState getCurrentViewModelState();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object execute(@org.jetbrains.annotations.NotNull()
    java.lang.Object newAction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}