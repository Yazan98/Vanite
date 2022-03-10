package io.vortex.android.utils.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:54 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lio/vortex/android/utils/utils/NetworkUtils;", "", "()V", "cm", "Landroid/net/ConnectivityManager;", "connectivityManager", "nwInfo", "Landroid/net/NetworkInfo;", "getNetworkInfo", "context", "Landroid/content/Context;", "isNetworkConnection", "", "vortex-utils_release"})
@java.lang.Deprecated()
public final class NetworkUtils {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.utils.NetworkUtils INSTANCE = null;
    private static android.net.ConnectivityManager connectivityManager;
    private static android.net.NetworkInfo nwInfo;
    private static android.net.ConnectivityManager cm;
    
    private NetworkUtils() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final boolean isNetworkConnection(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    private final android.net.NetworkInfo getNetworkInfo(android.content.Context context) {
        return null;
    }
}