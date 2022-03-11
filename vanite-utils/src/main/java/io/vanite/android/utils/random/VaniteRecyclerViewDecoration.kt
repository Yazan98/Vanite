package io.vanite.android.utils.random

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:52 AM
 */

class VaniteRecyclerViewDecoration(
    private val context: Context,
    orientation: Int,
    private val margin: Int
) : RecyclerView.ItemDecoration() {
    private val ATTRS = intArrayOf(android.R.attr.listDivider)

    val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL
    val VERTICAL_LIST = LinearLayoutManager.VERTICAL

    private var mDivider: Drawable
    private var mOrientation: Int = 0

    init {
        val a = context.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)!!
        a.recycle()
        setOrientation(orientation)
    }

    private fun setOrientation(orientation: Int) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw IllegalArgumentException("invalid orientation")
        }
        mOrientation = orientation
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent)
        } else {
            drawHorizontal(c, parent)
        }
    }

    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                .layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider!!.intrinsicHeight
            mDivider!!.setBounds(left + dpToPx(margin), top, right - dpToPx(margin), bottom)
            mDivider!!.draw(c)
        }
    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        val top = parent.paddingTop
        val bottom = parent.height - parent.paddingBottom

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child
                .layoutParams as RecyclerView.LayoutParams
            val left = child.right + params.rightMargin
            val right = left + mDivider!!.intrinsicHeight
            mDivider!!.setBounds(left, top + dpToPx(margin), right, bottom - dpToPx(margin))
            mDivider!!.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider!!.intrinsicHeight)
        } else {
            outRect.set(0, 0, mDivider!!.intrinsicWidth, 0)
        }
    }

    private fun dpToPx(dp: Int): Int {
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            r.displayMetrics
        ).roundToInt()
    }
}