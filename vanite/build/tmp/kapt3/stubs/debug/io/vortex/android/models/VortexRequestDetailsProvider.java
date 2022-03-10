package io.vortex.android.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011\u00a8\u0006&"}, d2 = {"Lio/vortex/android/models/VortexRequestDetailsProvider;", "Lio/vortex/android/models/VortexRequestDetails;", "token", "", "language", "isLoggingEnabled", "", "loggingTag", "loggingMode", "Lio/vortex/android/models/data/VortexInterceptorMode;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lio/vortex/android/models/data/VortexInterceptorMode;)V", "()Z", "setLoggingEnabled", "(Z)V", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "getLoggingMode", "()Lio/vortex/android/models/data/VortexInterceptorMode;", "setLoggingMode", "(Lio/vortex/android/models/data/VortexInterceptorMode;)V", "getLoggingTag", "setLoggingTag", "getToken", "setToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "vortex_debug"})
public final class VortexRequestDetailsProvider implements io.vortex.android.models.VortexRequestDetails {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String token;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String language;
    private boolean isLoggingEnabled;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String loggingTag;
    @org.jetbrains.annotations.NotNull()
    private io.vortex.android.models.data.VortexInterceptorMode loggingMode;
    
    @org.jetbrains.annotations.NotNull()
    public final io.vortex.android.models.VortexRequestDetailsProvider copy(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String language, boolean isLoggingEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String loggingTag, @org.jetbrains.annotations.NotNull()
    io.vortex.android.models.data.VortexInterceptorMode loggingMode) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public VortexRequestDetailsProvider() {
        super();
    }
    
    public VortexRequestDetailsProvider(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String language, boolean isLoggingEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String loggingTag, @org.jetbrains.annotations.NotNull()
    io.vortex.android.models.data.VortexInterceptorMode loggingMode) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isLoggingEnabled() {
        return false;
    }
    
    public final void setLoggingEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoggingTag() {
        return null;
    }
    
    public final void setLoggingTag(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.vortex.android.models.data.VortexInterceptorMode component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.vortex.android.models.data.VortexInterceptorMode getLoggingMode() {
        return null;
    }
    
    public final void setLoggingMode(@org.jetbrains.annotations.NotNull()
    io.vortex.android.models.data.VortexInterceptorMode p0) {
    }
}