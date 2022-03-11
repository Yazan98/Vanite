package io.vanite.android.utils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.FROYO
import android.view.Surface
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:53 AM
 */

object ScreenOrientationUtils {

    @SuppressLint("SourceLockedOrientationActivity")
    fun setPortraitOpientationScreen(context: AppCompatActivity) {
        context.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun setLandscapeOrientationScreen(context: AppCompatActivity) {
        context.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    fun lockOrientationLandscape(activity: AppCompatActivity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
    }

    fun lockOrientationPortrait(activity: AppCompatActivity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    @SuppressLint("ObsoleteSdkInt", "WrongConstant")
    fun lockOrientation(activity: AppCompatActivity) {
        val orientation = activity.resources.configuration.orientation
        val rotation = (activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            .rotation

        var SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8
        var SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9

        // Build.VERSION.SDK_INT <= Build.VERSION_CODES.FROYO
        if (SDK_INT > FROYO) {
            SCREEN_ORIENTATION_REVERSE_LANDSCAPE = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            SCREEN_ORIENTATION_REVERSE_PORTRAIT = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_90) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
        } else if (rotation == Surface.ROTATION_180 || rotation == Surface.ROTATION_270) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                activity.requestedOrientation = SCREEN_ORIENTATION_REVERSE_PORTRAIT
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                activity.requestedOrientation = SCREEN_ORIENTATION_REVERSE_LANDSCAPE
            }
        }
    }

    fun unlockOrientation(activity: AppCompatActivity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
    }

}