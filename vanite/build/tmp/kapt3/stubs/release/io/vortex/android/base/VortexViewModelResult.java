package io.vortex.android.base;

import java.lang.System;

/**
 * This ViewModel Type Used To Build ViewModel With Specific Api Response and Access
 * VortexRequestProvider Directly Without Create it from Sub Class
 *
 * Note: Full Implementation of An Vortex ViewModel With State, Action, RxJava is Available at @see VortexViewModel
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\u0004\b\u0002\u0010\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\nH\u0004\u00a8\u0006\u000b"}, d2 = {"Lio/vortex/android/base/VortexViewModelResult;", "State", "Lio/vortex/android/state/VortexState;", "Action", "Lio/vortex/android/VortexAction;", "Result", "Lio/vortex/android/base/VortexViewModel;", "Lio/vortex/android/VortexViewModelType;", "()V", "getRequestProvider", "Lio/vortex/android/rx/VortexRequestProvider;", "vortex_release"})
public abstract class VortexViewModelResult<State extends io.vortex.android.state.VortexState, Action extends io.vortex.android.VortexAction, Result extends java.lang.Object> extends io.vortex.android.base.VortexViewModel<State, Action> implements io.vortex.android.VortexViewModelType {
    
    public VortexViewModelResult() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.vortex.android.rx.VortexRequestProvider<Result> getRequestProvider() {
        return null;
    }
}