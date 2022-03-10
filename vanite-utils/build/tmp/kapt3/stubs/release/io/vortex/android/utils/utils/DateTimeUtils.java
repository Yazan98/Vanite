package io.vortex.android.utils.utils;

import java.lang.System;

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:55 AM
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lio/vortex/android/utils/utils/DateTimeUtils;", "", "()V", "getDate", "", "date", "Ljava/util/Date;", "getDateFromTimestamp", "timestamp", "", "getTimeAndDate", "pattern", "vortex-utils_release"})
public final class DateTimeUtils {
    @org.jetbrains.annotations.NotNull()
    public static final io.vortex.android.utils.utils.DateTimeUtils INSTANCE = null;
    
    private DateTimeUtils() {
        super();
    }
    
    /**
     * "yyyy.MM.dd G 'at' HH:mm:ss z" ---- 2001.07.04 AD at 12:08:56 PDT
     * "hh 'o''clock' a, zzzz" ----------- 12 o'clock PM, Pacific Daylight Time
     * "EEE, d MMM yyyy HH:mm:ss Z"------- Wed, 4 Jul 2001 12:08:56 -0700
     * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"------- 2001-07-04T12:08:56.235-0700
     * "yyMMddHHmmssZ"-------------------- 010704120856-0700
     * "K:mm a, z" ----------------------- 0:08 PM, PDT
     * "h:mm a" -------------------------- 12:08 PM
     * "EEE, MMM d, ''yy" ---------------- Wed, Jul 4, '01
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeAndDate(@org.jetbrains.annotations.NotNull()
    java.lang.String pattern) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateFromTimestamp(long timestamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return null;
    }
}