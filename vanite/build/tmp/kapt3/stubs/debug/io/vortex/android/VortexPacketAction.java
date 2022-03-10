package io.vortex.android;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lio/vortex/android/VortexPacketAction;", "B", "Lio/vortex/android/VortexAction;", "getActionBody", "()Ljava/lang/Object;", "vortex_debug"})
public abstract interface VortexPacketAction<B extends java.lang.Object> extends io.vortex.android.VortexAction {
    
    public abstract B getActionBody();
}