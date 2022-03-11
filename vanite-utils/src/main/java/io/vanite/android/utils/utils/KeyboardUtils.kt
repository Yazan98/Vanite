package io.vanite.android.utils.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:55 AM
 */

object KeyboardUtils {

    fun hideKeyboard(activity: AppCompatActivity) {
        val view = activity.findViewById<View>(android.R.id.content)
        if (view != null) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showKeyboard(activity: AppCompatActivity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun addKeyboardVisibilityListener(rootLayout: View, onKeyboardVisibiltyListener: OnKeyboardVisibiltyListener) {
        rootLayout.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            rootLayout.getWindowVisibleDisplayFrame(r)
            val screenHeight = rootLayout.rootView.height

            val keypadHeight = screenHeight - r.bottom

            val isVisible =
                keypadHeight > screenHeight * 0.15
            onKeyboardVisibiltyListener.onVisibilityChange(isVisible)
        }
    }

    interface OnKeyboardVisibiltyListener {
        fun onVisibilityChange(isVisible: Boolean)
    }

}