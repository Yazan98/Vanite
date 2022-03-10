package io.vortex.android.utils.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:54 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lio/vortex/android/utils/utils/LocationUtils;", "", "()V", "KEY_REQUESTING_LOCATION_UPDATES", "", "getKEY_REQUESTING_LOCATION_UPDATES", "()Ljava/lang/String;", "enableLocationSettings", "", "context", "Landroid/content/Context;", "interval", "", "fastInterval", "priority", "", "getLocationText", "location", "Landroid/location/Location;", "getLocationTitle", "requestingLocationUpdates", "", "setRequestingLocationUpdates", "vortex-utils_debug"})
public final class LocationUtils {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.utils.LocationUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_REQUESTING_LOCATION_UPDATES = "requesting_locaction_updates";
    
    private LocationUtils() {
        super();
    }
    
    /**
     * Priority : LocationRequest.PRIORITY_HIGH_ACCURACY
     */
    public final void enableLocationSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long interval, long fastInterval, int priority) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKEY_REQUESTING_LOCATION_UPDATES() {
        return null;
    }
    
    /**
     * Returns true if requesting location updates, otherwise returns false.
     *
     * @param context The [Context].
     */
    public final boolean requestingLocationUpdates(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Stores the location updates state in SharedPreferences.
     * @param requestingLocationUpdates The location updates state.
     */
    public final void setRequestingLocationUpdates(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean requestingLocationUpdates) {
    }
    
    /**
     * Returns the `location` object as a human readable string.
     * @param location  The [Location].
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocationText(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocationTitle(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}