package io.vortex.android.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:52 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\n\u001a\u00020\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tH\u0016J\u0019\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0000H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0003H\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\"\u001a\u00020\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010#\u001a\u00020\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lio/vortex/android/utils/VortexConfiguration;", "Lio/vortex/android/utils/VortexConfigurationImpl;", "Lio/vortex/android/keys/LoggerType;", "Lio/vortex/android/keys/ImageLoader;", "()V", "applicationStatus", "", "isPlatformCheckRequired", "vortexApplication", "Landroid/app/Application;", "checkPlatformRequiredConfiguration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerApplicationClass", "app", "registerApplicationLogger", "logger", "(Lio/vortex/android/keys/LoggerType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerApplicationState", "state", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCompatVector", "registerExceptionHandler", "handler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "(Ljava/lang/Thread$UncaughtExceptionHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerFabric", "registerFirebaseConfiguration", "moduleName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerImageLoader", "imageLoader", "(Lio/vortex/android/keys/ImageLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerStrictMode", "registerUserStoryConfiguration", "registerVortexPermissionsSettings", "registerVortexPrefsConfiguration", "details", "Lio/vortex/android/models/VortexPrefsDetails;", "application", "vortex-utils_debug"})
public final class VortexConfiguration implements io.vortex.android.utils.VortexConfigurationImpl<io.vortex.android.keys.LoggerType, io.vortex.android.keys.ImageLoader> {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.VortexConfiguration INSTANCE = null;
    private static boolean applicationStatus = false;
    private static android.app.Application vortexApplication;
    private static boolean isPlatformCheckRequired = false;
    
    private VortexConfiguration() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.vortex.android.utils.VortexConfiguration registerApplicationClass(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerApplicationLogger(@org.jetbrains.annotations.NotNull()
    io.vortex.android.keys.LoggerType logger, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @java.lang.Deprecated()
    public java.lang.Object registerImageLoader(@org.jetbrains.annotations.NotNull()
    io.vortex.android.keys.ImageLoader imageLoader, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerApplicationState(boolean state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {io.vortex.android.errors.VortexFirebaseConfigurationException.class})
    @java.lang.Override()
    @java.lang.Deprecated()
    public java.lang.Object registerFirebaseConfiguration(@org.jetbrains.annotations.NotNull()
    java.lang.String moduleName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerStrictMode(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerExceptionHandler(@org.jetbrains.annotations.NotNull()
    java.lang.Thread.UncaughtExceptionHandler handler, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerCompatVector(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @java.lang.Deprecated()
    public java.lang.Object registerFabric(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object checkPlatformRequiredConfiguration(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.vortex.android.utils.VortexConfiguration registerVortexPrefsConfiguration(@org.jetbrains.annotations.NotNull()
    io.vortex.android.models.VortexPrefsDetails details, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerUserStoryConfiguration(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object registerVortexPermissionsSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation) {
        return null;
    }
}