package io.vortex.android.utils.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:53 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lio/vortex/android/utils/utils/ScreenUtils;", "", "()V", "configuration", "Landroid/content/res/Configuration;", "getScreenSize", "", "context", "Landroid/content/Context;", "hasLargeScreen", "", "hasNormalScreen", "hasSmallScreen", "isTablet", "vortex-utils_release"})
public final class ScreenUtils {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.utils.ScreenUtils INSTANCE = null;
    private static android.content.res.Configuration configuration;
    
    private ScreenUtils() {
        super();
    }
    
    public final boolean isTablet(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasSmallScreen(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasNormalScreen(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasLargeScreen(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    private final int getScreenSize(android.content.Context context) {
        return 0;
    }
}