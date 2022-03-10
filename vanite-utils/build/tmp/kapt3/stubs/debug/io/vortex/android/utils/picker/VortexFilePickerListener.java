package io.vortex.android.utils.picker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lio/vortex/android/utils/picker/VortexFilePickerListener;", "", "onFilePicked", "", "type", "Lio/vortex/android/utils/picker/PickMethod;", "data", "Landroid/net/Uri;", "reqCode", "", "(Lio/vortex/android/utils/picker/PickMethod;Landroid/net/Uri;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vortex-utils_debug"})
public abstract interface VortexFilePickerListener {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object onFilePicked(@org.jetbrains.annotations.NotNull()
    io.vortex.android.utils.picker.PickMethod type, @org.jetbrains.annotations.NotNull()
    android.net.Uri data, int reqCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}