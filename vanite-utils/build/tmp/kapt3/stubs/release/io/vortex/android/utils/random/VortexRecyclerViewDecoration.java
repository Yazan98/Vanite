package io.vortex.android.utils.random;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:52 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lio/vortex/android/utils/random/VortexRecyclerViewDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "orientation", "", "margin", "(Landroid/content/Context;II)V", "ATTRS", "", "HORIZONTAL_LIST", "getHORIZONTAL_LIST", "()I", "VERTICAL_LIST", "getVERTICAL_LIST", "mDivider", "Landroid/graphics/drawable/Drawable;", "mOrientation", "dpToPx", "dp", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "setOrientation", "vortex-utils_release"})
public final class VortexRecyclerViewDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private final android.content.Context context = null;
    private final int margin = 0;
    private final int[] ATTRS = {android.R.attr.listDivider};
    private final int HORIZONTAL_LIST = androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;
    private final int VERTICAL_LIST = androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;
    private android.graphics.drawable.Drawable mDivider;
    private int mOrientation = 0;
    
    public VortexRecyclerViewDecoration(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int orientation, int margin) {
        super();
    }
    
    public final int getHORIZONTAL_LIST() {
        return 0;
    }
    
    public final int getVERTICAL_LIST() {
        return 0;
    }
    
    private final void setOrientation(int orientation) {
    }
    
    @java.lang.Override()
    public void onDrawOver(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas c, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    private final void drawVertical(android.graphics.Canvas c, androidx.recyclerview.widget.RecyclerView parent) {
    }
    
    private final void drawHorizontal(android.graphics.Canvas c, androidx.recyclerview.widget.RecyclerView parent) {
    }
    
    @java.lang.Override()
    public void getItemOffsets(@org.jetbrains.annotations.NotNull()
    android.graphics.Rect outRect, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    private final int dpToPx(int dp) {
        return 0;
    }
}