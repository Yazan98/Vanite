package io.vortex.android.errors;

import java.lang.System;

/**
 * This Exception is the base exception for all errors at vortex library to log the exception details at logcat
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2 = {"Lio/vortex/android/errors/VortexException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "details", "Lio/vortex/android/models/VortexExceptionDetails;", "(Lio/vortex/android/models/VortexExceptionDetails;)V", "repeatDash", "", "vortex_release"})
public class VortexException extends java.lang.RuntimeException {
    
    public VortexException(@org.jetbrains.annotations.NotNull()
    io.vortex.android.models.VortexExceptionDetails<?> details) {
        super();
    }
    
    private final java.lang.String repeatDash() {
        return null;
    }
}