package io.vortex.android.rx;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 9:04 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005"}, d2 = {"Lio/vortex/android/rx/VortexThreadProvider;", "", "getBackgroundThread", "Lio/reactivex/Scheduler;", "getMainThread", "vortex_debug"})
public abstract interface VortexThreadProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Scheduler getMainThread();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Scheduler getBackgroundThread();
    
    /**
     * Created By : Yazan Tarifi
     * Date : 10/9/2019
     * Time : 9:04 PM
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Scheduler getMainThread(@org.jetbrains.annotations.NotNull()
        io.vortex.android.rx.VortexThreadProvider $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static io.reactivex.Scheduler getBackgroundThread(@org.jetbrains.annotations.NotNull()
        io.vortex.android.rx.VortexThreadProvider $this) {
            return null;
        }
    }
}