package io.vortex.android;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 1/3/2020
 * Time : 3:00 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lio/vortex/android/VortexNetworkListener;", "", "onNetworkConnected", "", "onNetworkDisconnected", "vortex_debug"})
public abstract interface VortexNetworkListener {
    
    public abstract void onNetworkConnected();
    
    public abstract void onNetworkDisconnected();
}