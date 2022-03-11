package io.vanite.android.utils.utils

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:54 AM
 */

object RecyclerViewUtils {

    @Deprecated("Not Used in RecyclerViews Anymore", ReplaceWith("Unit"))
    fun highCacheRecyclerView(recyclerView: RecyclerView, count: Int, isItemsSameSize: Boolean) = Unit
    fun withLinerLayout(recyclerView: RecyclerView?, context: Context?) {
        recyclerView?.layoutManager = LinearLayoutManager(context)
    }

    fun withGridLayout(recyclerView: RecyclerView?, context: Context, rowItems: Int) {
        recyclerView?.layoutManager = GridLayoutManager(context, rowItems)
    }

}