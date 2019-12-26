package io.vortex.android.utils.ui

import android.graphics.Paint
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created By : Yazan Tarifi
 * Date : 12/26/2019
 * Time : 10:07 PM
 */

suspend fun AppCompatActivity.fadeInAnimation(repeatCount: Int, view: View) {
    withContext(Dispatchers.Main) {
        val anim = AlphaAnimation(1.0f, 0.0f)
        anim.duration = 1000
        anim.repeatCount = repeatCount
        anim.repeatMode = Animation.REVERSE
        view.startAnimation(anim)
    }
}

suspend fun AppCompatActivity.fadeOutAnimation(repeatCount: Int, view: View) {
    withContext(Dispatchers.Main) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        anim.repeatCount = repeatCount
        anim.repeatMode = Animation.REVERSE
        view.startAnimation(anim)
    }
}

suspend fun Fragment.fadeInAnimation(repeatCount: Int, view: View) {
    withContext(Dispatchers.Main) {
        val anim = AlphaAnimation(1.0f, 0.0f)
        anim.duration = 1000
        anim.repeatCount = repeatCount
        anim.repeatMode = Animation.REVERSE
        view.startAnimation(anim)
    }
}

suspend fun Fragment.fadeOutAnimation(repeatCount: Int, view: View) {
    withContext(Dispatchers.Main) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        anim.repeatCount = repeatCount
        anim.repeatMode = Animation.REVERSE
        view.startAnimation(anim)
    }
}

fun TextView.underline() {
    paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
}

suspend fun View.showView() {
    withContext(Dispatchers.Main) {
        visibility = View.VISIBLE
    }
}

suspend fun View.hideView() {
    withContext(Dispatchers.Main) {
        visibility = View.GONE
    }
}
