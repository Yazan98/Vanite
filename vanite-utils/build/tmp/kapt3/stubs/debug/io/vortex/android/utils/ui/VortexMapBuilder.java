package io.vortex.android.utils.ui;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 12/26/2019
 * Time : 10:13 PM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ1\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ)\u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lio/vortex/android/utils/ui/VortexMapBuilder;", "", "()V", "activateAutoCompleteGoogleMaps", "", "fragment", "Landroidx/fragment/app/Fragment;", "id", "", "listener", "Lio/vortex/android/utils/ui/VortexMapBuilder$AutoPlaceConfiguration;", "(Landroidx/fragment/app/Fragment;ILio/vortex/android/utils/ui/VortexMapBuilder$AutoPlaceConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMarkerToMap", "position", "Lcom/google/android/gms/maps/model/LatLng;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "title", "", "icon", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/GoogleMap;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMapFromActivity", "Lcom/google/android/gms/maps/SupportMapFragment;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "createMapFromFragment", "getApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "Landroid/content/Context;", "connectionListener", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "moveCamera", "zoom", "", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/GoogleMap;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AutoPlaceConfiguration", "vortex-utils_debug"})
public final class VortexMapBuilder {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.ui.VortexMapBuilder INSTANCE = null;
    
    private VortexMapBuilder() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.SupportMapFragment createMapFromFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.common.api.GoogleApiClient getApiClient(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectionListener) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.SupportMapFragment createMapFromActivity(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity context, int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addMarkerToMap(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng position, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap mMap, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int icon, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object moveCamera(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng position, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap mMap, float zoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object activateAutoCompleteGoogleMaps(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, int id, @org.jetbrains.annotations.NotNull()
    io.vortex.android.utils.ui.VortexMapBuilder.AutoPlaceConfiguration listener, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lio/vortex/android/utils/ui/VortexMapBuilder$AutoPlaceConfiguration;", "", "onError", "", "p0", "Lcom/google/android/gms/common/api/Status;", "onPlacePicked", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "vortex-utils_debug"})
    public static abstract interface AutoPlaceConfiguration {
        
        public abstract void onPlacePicked(@org.jetbrains.annotations.NotNull()
        com.google.android.gms.maps.model.LatLng latLng);
        
        public abstract void onError(@org.jetbrains.annotations.NotNull()
        com.google.android.gms.common.api.Status p0);
    }
}