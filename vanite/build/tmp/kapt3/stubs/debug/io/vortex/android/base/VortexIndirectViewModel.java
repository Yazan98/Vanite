package io.vortex.android.base;

import java.lang.System;

/**
 * VortexViewModel Class (One of Supported ViewModels)
 * Used to ViewModels That only Needs to Manage State Without Actions
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lio/vortex/android/base/VortexIndirectViewModel;", "State", "Lio/vortex/android/base/VortexPureViewModel;", "Lio/vortex/android/VortexIndirectViewModelImpl;", "Lio/vortex/android/VortexViewModelType;", "()V", "state", "Landroidx/lifecycle/MutableLiveData;", "getState", "()Landroidx/lifecycle/MutableLiveData;", "state$delegate", "Lkotlin/Lazy;", "acceptNewState", "", "newState", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentState", "()Ljava/lang/Object;", "getStateHandler", "vortex_debug"})
public abstract class VortexIndirectViewModel<State extends java.lang.Object> extends io.vortex.android.base.VortexPureViewModel implements io.vortex.android.VortexIndirectViewModelImpl<State>, io.vortex.android.VortexViewModelType {
    private final kotlin.Lazy state$delegate = null;
    
    public VortexIndirectViewModel() {
        super();
    }
    
    private final androidx.lifecycle.MutableLiveData<State> getState() {
        return null;
    }
    
    /**
     * Override The Current State With Your New State By Using This Method
     * To Accept New State
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object acceptNewState(State newState, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Get Current State To Subscribe it With Current ViewLifecycleOwner
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<State> getStateHandler() {
        return null;
    }
    
    /**
     * Get Current Value of Current Saved State in this ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public State getCurrentState() {
        return null;
    }
}