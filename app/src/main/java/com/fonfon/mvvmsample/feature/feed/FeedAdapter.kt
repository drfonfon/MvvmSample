package com.fonfon.mvvmsample.feature.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fonfon.mvvmsample.R
import com.fonfon.mvvmsample.core.scope.PerFragment
import com.fonfon.mvvmsample.data.domian.Photo
import javax.inject.Inject

@PerFragment
class FeedAdapter @Inject constructor() : RecyclerView.Adapter<FeedAdapter.Holder>() {

    val items = ArrayList<Photo>()

    var onCLick: ((photo: Photo) -> Unit)? = null

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener { onCLick?.invoke(items[position]) }
        (holder.itemView as TextView).text = items[position].id.toString()
    }
}