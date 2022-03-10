package io.vortex.android.utils.ui;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 12/26/2019
 * Time : 9:31 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u0006J)\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J+\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lio/vortex/android/utils/ui/VortexGifController;", "", "()V", "listener", "Lio/vortex/android/utils/ui/VortexGifListener;", "attachListener", "", "convertDpToPixel", "", "dp", "context", "Landroid/content/Context;", "destroyGifController", "startAnimationWithFresco", "settings", "Lio/vortex/android/models/ui/VortexAnimationSettings;", "image", "Landroid/view/View;", "isAutoPlay", "", "(Lio/vortex/android/models/ui/VortexAnimationSettings;Landroid/view/View;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAnimationWithGlide", "Landroid/widget/ImageView;", "(Lio/vortex/android/models/ui/VortexAnimationSettings;Landroid/content/Context;Landroid/widget/ImageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vortex-utils_debug"})
public final class VortexGifController {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.ui.VortexGifController INSTANCE = null;
    private static io.vortex.android.utils.ui.VortexGifListener listener;
    
    private VortexGifController() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startAnimationWithGlide(@org.jetbrains.annotations.NotNull()
    io.vortex.android.models.ui.VortexAnimationSettings settings, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Deprecated()
    public final java.lang.Object startAnimationWithFresco(@org.jetbrains.annotations.NotNull()
    io.vortex.android.models.ui.VortexAnimationSettings settings, @org.jetbrains.annotations.NotNull()
    android.view.View image, boolean isAutoPlay, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void attachListener(@org.jetbrains.annotations.NotNull()
    io.vortex.android.utils.ui.VortexGifListener listener) {
    }
    
    public final void destroyGifController() {
    }
    
    private final float convertDpToPixel(float dp, android.content.Context context) {
        return 0.0F;
    }
}