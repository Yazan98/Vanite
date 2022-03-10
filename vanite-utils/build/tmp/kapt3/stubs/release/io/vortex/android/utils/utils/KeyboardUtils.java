package io.vortex.android.utils.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:55 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\u000e"}, d2 = {"Lio/vortex/android/utils/utils/KeyboardUtils;", "", "()V", "addKeyboardVisibilityListener", "", "rootLayout", "Landroid/view/View;", "onKeyboardVisibiltyListener", "Lio/vortex/android/utils/utils/KeyboardUtils$OnKeyboardVisibiltyListener;", "hideKeyboard", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "showKeyboard", "OnKeyboardVisibiltyListener", "vortex-utils_release"})
public final class KeyboardUtils {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.utils.KeyboardUtils INSTANCE = null;
    
    private KeyboardUtils() {
        super();
    }
    
    public final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
    }
    
    public final void showKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
    }
    
    public final void addKeyboardVisibilityListener(@org.jetbrains.annotations.NotNull()
    android.view.View rootLayout, @org.jetbrains.annotations.NotNull()
    io.vortex.android.utils.utils.KeyboardUtils.OnKeyboardVisibiltyListener onKeyboardVisibiltyListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lio/vortex/android/utils/utils/KeyboardUtils$OnKeyboardVisibiltyListener;", "", "onVisibilityChange", "", "isVisible", "", "vortex-utils_release"})
    public static abstract interface OnKeyboardVisibiltyListener {
        
        public abstract void onVisibilityChange(boolean isVisible);
    }
}