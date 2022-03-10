package io.vortex.android.utils.language;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:45 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J!\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0003J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lio/vortex/android/utils/language/VortexLocaleManager;", "", "()V", "SELECTED_LANGUAGE", "", "getSELECTED_LANGUAGE", "()Ljava/lang/String;", "getLanguage", "context", "Landroid/content/Context;", "getPersistedData", "defaultLanguage", "isLanguageEn", "", "onAttach", "persist", "", "language", "selectLanguage", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLocale", "updateResources", "updateResourcesLegacy", "vortex-utils_debug"})
public final class VortexLocaleManager {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.language.VortexLocaleManager INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SELECTED_LANGUAGE = "Locale.Language";
    
    private VortexLocaleManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSELECTED_LANGUAGE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultLanguage) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguage(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context setLocale(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String language) {
        return null;
    }
    
    private final java.lang.String getPersistedData(android.content.Context context, java.lang.String defaultLanguage) {
        return null;
    }
    
    private final void persist(android.content.Context context, java.lang.String language) {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.N)
    private final android.content.Context updateResources(android.content.Context context, java.lang.String language) {
        return null;
    }
    
    private final android.content.Context updateResourcesLegacy(android.content.Context context, java.lang.String language) {
        return null;
    }
    
    public final boolean isLanguageEn(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}