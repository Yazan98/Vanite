package io.vortex.android.utils.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:54 AM
 */

object RecyclerViewUtils {

    fun highCacheRecyclerView(recyclerView: RecyclerView, count: Int, isItemsSameSize: Boolean) {
        recyclerView.setHasFixedSize(isItemsSameSize)
        recyclerView.setItemViewCacheSize(count)
        recyclerView.isDrawingCacheEnabled = true
        recyclerView.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
    }

    fun withLinerLayout(recyclerView: RecyclerView?, context: Context?) {
        recyclerView!!.layoutManager = LinearLayoutManager(context)
    }

    fun withGridLayout(recyclerView: RecyclerView, context: Context, rowItems: Int) {
        recyclerView.layoutManager = GridLayoutManager(context, rowItems)
    }

}