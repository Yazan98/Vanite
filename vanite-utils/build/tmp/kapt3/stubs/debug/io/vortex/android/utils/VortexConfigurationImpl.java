package io.vortex.android.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 9:52 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0011\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00028\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u001d\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u001e\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u001f\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lio/vortex/android/utils/VortexConfigurationImpl;", "L", "I", "", "checkPlatformRequiredConfiguration", "Lio/vortex/android/utils/VortexConfiguration;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerApplicationClass", "app", "Landroid/app/Application;", "registerApplicationLogger", "logger", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerApplicationState", "state", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCompatVector", "registerExceptionHandler", "handler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "(Ljava/lang/Thread$UncaughtExceptionHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerFabric", "registerFirebaseConfiguration", "moduleName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerImageLoader", "imageLoader", "registerStrictMode", "registerUserStoryConfiguration", "registerVortexPermissionsSettings", "registerVortexPrefsConfiguration", "details", "Lio/vortex/android/models/VortexPrefsDetails;", "application", "vortex-utils_debug"})
public abstract interface VortexConfigurationImpl<L extends java.lang.Object, I extends java.lang.Object> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.vortex.android.utils.VortexConfiguration registerApplicationClass(@org.jetbrains.annotations.NotNull()
    android.app.Application app);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerApplicationLogger(L logger, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerImageLoader(I imageLoader, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerApplicationState(boolean state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {io.vortex.android.errors.VortexFirebaseConfigurationException.class})
    public abstract java.lang.Object registerFirebaseConfiguration(@org.jetbrains.annotations.NotNull()
    java.lang.String moduleName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerStrictMode(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerExceptionHandler(@org.jetbrains.annotations.NotNull()
    java.lang.Thread.UncaughtExceptionHandler handler, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerCompatVector(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerFabric(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkPlatformRequiredConfiguration(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.vortex.android.utils.VortexConfiguration registerVortexPrefsConfiguration(@org.jetbrains.annotations.NotNull()
    io.vortex.android.models.VortexPrefsDetails details, @org.jetbrains.annotations.NotNull()
    android.app.Application application);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerUserStoryConfiguration(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerVortexPermissionsSettings(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.vortex.android.utils.VortexConfiguration> continuation);
}