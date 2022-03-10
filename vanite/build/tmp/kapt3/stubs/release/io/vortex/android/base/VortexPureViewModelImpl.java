package io.vortex.android.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lio/vortex/android/base/VortexPureViewModelImpl;", "", "addRxRequest", "", "request", "Lio/reactivex/disposables/Disposable;", "getRxRepository", "Lio/vortex/android/rx/VortexRxRepository;", "vortex_release"})
public abstract interface VortexPureViewModelImpl {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.vortex.android.rx.VortexRxRepository getRxRepository();
    
    public abstract void addRxRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable request);
}