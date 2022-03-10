package io.vortex.android.utils.picker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J-\u0010\u0016\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ#\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ#\u0010 \u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lio/vortex/android/utils/picker/VortexFileAttachPicker;", "", "()V", "listener", "Lio/vortex/android/utils/picker/VortexFilePickerListener;", "pickerState", "Lio/vortex/android/utils/picker/PickMethod;", "addFileListener", "", "newListener", "(Lio/vortex/android/utils/picker/VortexFilePickerListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyFileAttach", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileNameByUri", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "uri", "Landroid/net/Uri;", "getIntentByMethod", "Landroid/content/Intent;", "method", "onFileResult", "requestCode", "", "data", "(Landroidx/fragment/app/FragmentActivity;ILandroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCameraAttach", "context", "reqCode", "(Landroidx/fragment/app/FragmentActivity;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startFilesAttach", "startImagesAttach", "vortex-utils_release"})
public final class VortexFileAttachPicker {
    private io.vortex.android.utils.picker.PickMethod pickerState = io.vortex.android.utils.picker.PickMethod.GALLERY;
    private io.vortex.android.utils.picker.VortexFilePickerListener listener;
    
    public VortexFileAttachPicker() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startImagesAttach(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity context, int reqCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startFilesAttach(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity context, int reqCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startCameraAttach(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity context, int reqCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final android.content.Intent getIntentByMethod(io.vortex.android.utils.picker.PickMethod method) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onFileResult(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, int requestCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileNameByUri(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addFileListener(@org.jetbrains.annotations.NotNull()
    io.vortex.android.utils.picker.VortexFilePickerListener newListener, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object destroyFileAttach(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}