package io.vanite.android.utils.random

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:49 AM
 */

class VaniteDeviceInfo(private val applicationContext: Context) {

    fun getAndroidVersion(): String {
        val release = Build.VERSION.RELEASE
        val sdkVersion = Build.VERSION.SDK_INT
        return "Android SDK: $sdkVersion ($release)"
    }

    fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer)) {
            capitalize(model)
        } else {
            capitalize(manufacturer) + " " + model
        }
    }

    @SuppressLint("HardwareIds")
    fun getDeviceId(): String {
        return Settings.Secure.getString(
            applicationContext.contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }

    private fun capitalize(s: String?): String {
        if (s == null || s.isEmpty()) {
            return ""
        }
        val first = s[0]
        return if (Character.isUpperCase(first)) {
            s
        } else {
            Character.toUpperCase(first) + s.substring(1)
        }
    }

    private fun getDeviceInfo(): String {
        var s = "Device Info : "
        s += "\n OS Version: " + System.getProperty("os.version") + "(" + Build.VERSION.INCREMENTAL + ")"
        s += "\n OS API Level: ${Build.VERSION.SDK_INT}"
        s += "\n Device: " + Build.DEVICE
        s += "\n Model (and Product): " + Build.MODEL + " (" + Build.PRODUCT + ")"
        return s
    }

    fun getApplicationName(): String {
        val applicationInfo = applicationContext.applicationInfo
        val stringId = applicationInfo.labelRes
        return if (stringId == 0) applicationInfo.nonLocalizedLabel.toString() else applicationContext.getString(
            stringId
        )
    }

}