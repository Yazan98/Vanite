package io.vortex.android.state;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 12:01 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lio/vortex/android/state/VortexLoadingState;", "Lio/vortex/android/state/VortexState;", "loadingState", "", "(Z)V", "getLoadingState", "vortex_release"})
public final class VortexLoadingState implements io.vortex.android.state.VortexState {
    private final boolean loadingState = false;
    
    public VortexLoadingState(boolean loadingState) {
        super();
    }
    
    public final boolean getLoadingState() {
        return false;
    }
}