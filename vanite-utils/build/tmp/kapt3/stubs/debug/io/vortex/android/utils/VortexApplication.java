package io.vortex.android.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:49 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0015J\b\u0010\r\u001a\u00020\u000eH\u0004J\u0011\u0010\u000f\u001a\u00020\nH\u0085@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u001b\u0010\u0003\u001a\u00020\u00048DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lio/vortex/android/utils/VortexApplication;", "Landroidx/multidex/MultiDexApplication;", "()V", "notificationsController", "Lio/vortex/android/utils/VortexNotificationController;", "getNotificationsController", "()Lio/vortex/android/utils/VortexNotificationController;", "notificationsController$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "base", "Landroid/content/Context;", "getDeviceInfo", "Lio/vortex/android/utils/random/VortexDeviceInfo;", "setupFresco", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupNotificationChannels", "clannels", "", "Lio/vortex/android/models/ui/VortexNotificationDetails;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupTimber", "applicationStatus", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vortex-utils_debug"})
public class VortexApplication extends androidx.multidex.MultiDexApplication {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy notificationsController$delegate = null;
    
    public VortexApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.vortex.android.utils.VortexNotificationController getNotificationsController() {
        return null;
    }
    
    /**
     * When You Need To Show Notifications THe New Android Sdk Requires Notification Channel
     * To Show THis Notification For User And Here you are Initializing The Channels
     */
    @org.jetbrains.annotations.Nullable()
    protected final java.lang.Object setupNotificationChannels(@org.jetbrains.annotations.NotNull()
    java.util.List<io.vortex.android.models.ui.VortexNotificationDetails> clannels, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Setup Fresco Configuration
     * This Configuration Should Initialize Fresco On Background Thread With Buffer Memory
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Deprecated()
    protected final java.lang.Object setupFresco(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * If (applicationState) is True Timber Should Print in Logcat if False
     * It should print on Crashlitycs
     */
    @org.jetbrains.annotations.Nullable()
    protected final java.lang.Object setupTimber(boolean applicationStatus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.vortex.android.utils.random.VortexDeviceInfo getDeviceInfo() {
        return null;
    }
}