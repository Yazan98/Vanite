package io.vortex.android.models;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:48 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lio/vortex/android/models/VortexExceptionDetails;", "B", "", "getExceptionBody", "()Ljava/lang/Object;", "getExceptionMessage", "", "vortex_release"})
public abstract interface VortexExceptionDetails<B extends java.lang.Object> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getExceptionMessage();
    
    public abstract B getExceptionBody();
}