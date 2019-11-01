package com.powellapps.freela.ui.freela.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.powellapps.freela.R
import com.powellapps.freela.model.Feed
import kotlinx.android.synthetic.main.adapter_feed.view.*
import java.util.ArrayList

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    var feed : List<Feed> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_feed, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feed.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feed.get(position))
    }

    fun update(list: ArrayList<Feed>) {
        this.feed = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(feed: Feed) {
            itemView.textView_name_user.text = feed.userName
            itemView.textView_value.text = feed.freela.hourValue.toString()
            itemView.textView_language.text = feed.freela.language
            itemView.textView_level.text = feed.freela.name
            itemView.textView_date.text = feed.freela.date.toString()
            Glide.with(itemView)
                .load(feed.userPhoto)
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.imageView_photo);
        }

    }
}