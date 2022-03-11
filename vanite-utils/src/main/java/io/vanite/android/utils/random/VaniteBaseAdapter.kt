package io.vanite.android.utils.random

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created By : Yazan Tarifi
 * Date : 10/13/2019
 * Time : 1:50 AM
 */

abstract class VaniteBaseAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(context).inflate(getLayoutRes(), parent, false)
        return getViewHolder(v)
    }

    protected abstract fun getLayoutRes(): Int
    protected abstract fun getViewHolder(view: View): VH

}