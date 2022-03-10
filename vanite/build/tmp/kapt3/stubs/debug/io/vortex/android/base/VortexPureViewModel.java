package io.vortex.android.base;

import java.lang.System;

/**
 * This ViewModel Type Used To Handle Api's Without Any State Saved or The State Will be Managed
 * By The Sub Class
 *
 * This ViewModel Only Managed VortexRxRepository With RxJava Requests
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lio/vortex/android/base/VortexPureViewModel;", "Landroidx/lifecycle/ViewModel;", "Lio/vortex/android/base/VortexPureViewModelImpl;", "Lio/vortex/android/VortexViewModelType;", "()V", "repository", "Lio/vortex/android/rx/VortexRxRepository;", "getRepository", "()Lio/vortex/android/rx/VortexRxRepository;", "repository$delegate", "Lkotlin/Lazy;", "addRxRequest", "", "request", "Lio/reactivex/disposables/Disposable;", "getRxRepository", "onCleared", "vortex_debug"})
public abstract class VortexPureViewModel extends androidx.lifecycle.ViewModel implements io.vortex.android.base.VortexPureViewModelImpl, io.vortex.android.VortexViewModelType {
    private final kotlin.Lazy repository$delegate = null;
    
    public VortexPureViewModel() {
        super();
    }
    
    private final io.vortex.android.rx.VortexRxRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.vortex.android.rx.VortexRxRepository getRxRepository() {
        return null;
    }
    
    @java.lang.Override()
    public void addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}