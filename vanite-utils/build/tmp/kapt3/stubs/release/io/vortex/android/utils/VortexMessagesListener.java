package io.vortex.android.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 12/24/2019
 * Time : 11:49 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lio/vortex/android/utils/VortexMessagesListener;", "Landroid/content/BroadcastReceiver;", "()V", "action", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "vortex-utils_release"})
public final class VortexMessagesListener extends android.content.BroadcastReceiver {
    private final java.lang.String action = "android.provider.Telephony.SMS_RECEIVED";
    
    public VortexMessagesListener() {
        super();
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
}