package io.vanite.android.utils.ui

import android.content.Context
import android.graphics.Paint
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

suspend fun View.goneView() {
    withContext(Dispatchers.Main) {
        visibility = View.GONE
    }
}

suspend fun View.invisibleView() {
    withContext(Dispatchers.Main) {
        visibility = View.INVISIBLE
    }
}

suspend fun RecyclerView.gridLayout(context: Context, rows: Int) {
    withContext(Dispatchers.Main) {
        layoutManager = GridLayoutManager(context, rows)
    }
}

suspend fun RecyclerView.linearVerticalLayout(context: Context) {
    withContext(Dispatchers.Main) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}

suspend fun RecyclerView.linearHorizontalLayout(context: Context) {
    withContext(Dispatchers.Main) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}
