package com.example.ktvkontakte

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//class ListAdapter(var list: List<ListItem>,
//val itemClickListener: RecyclerViewItemClick? = null) :
//    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
//
//
//    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        fun bind(post: ListItem) {
//
//            val tvGroup = itemView.findViewById<TextView>(R.id.tvGroup)
//            val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
//            val tvHeading = itemView.findViewById<TextView>(R.id.tvHeading)
//            val tvLikes = itemView.findViewById<TextView>(R.id.tvLikes)
//            val tvComments = itemView.findViewById<TextView>(R.id.tvComment)
//            val tvViews = itemView.findViewById<TextView>(R.id.tvViews)
//            val ivPost = itemView.findViewById<ImageView>(R.id.ivPost)
//            val ivGroupPhoto = itemView.findViewById<ImageView>(R.id.ivGroupPhoto)
//            val cardView = itemView.findViewById<View>(R.id.cardView)
//            val ibLikes = itemView.findViewById<ImageButton>(R.id.iblike)
//            val tvShares = itemView.findViewById<TextView>(R.id.tvShare)
//
//            tvGroup.text = post.groupName;
//            tvHeading.text = post.heading;
//            tvLikes.text = post.likes;
//            tvComments.text = post.comments;
//            tvViews.text = post.views;
//            tvTime.text = post.publishDate;
//            tvShares.text = post.shares;
//
//            Picasso.with(view.context)
//                .load(post.imgURL)
//                .into(ivPost)
//
//            Picasso.with(view.context)
//                .load(post.imgURL)
//                .into(ivGroupPhoto)
//
//            view.setOnClickListener {
//                itemClickListener?.itemClick(adapterPosition, post)
//            }
//
//        }
//    }
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_items, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = list.size ?: 0
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    interface RecyclerViewItemClick {
//        fun itemClick(position: Int, item: ListItem)
//    }
//}









































class ListAdapter(var listItems: List<ListItem>,
                  val itemClickListener: RecyclerViewItemClick? = null) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.news_items, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = listItems.size ?: 0

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: ListItem) {
            val tvGroup = itemView.findViewById<TextView>(R.id.tvGroup)
            val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
            val tvHeading = itemView.findViewById<TextView>(R.id.tvHeading)
            val tvLikes = itemView.findViewById<TextView>(R.id.tvLikes)
            val tvComments = itemView.findViewById<TextView>(R.id.tvComment)
            val tvViews = itemView.findViewById<TextView>(R.id.tvViews)
            val ivPost = itemView.findViewById<ImageView>(R.id.ivPost)
            val ivGroupPhoto = itemView.findViewById<ImageView>(R.id.ivGroupPhoto)
            val ibLikes = itemView.findViewById<ImageButton>(R.id.iblike)
            val tvShares = itemView.findViewById<TextView>(R.id.tvShare)

            tvGroup.text = post.groupName
            tvHeading.text = post.heading
            tvLikes.text = post.likes
            tvComments.text = post.comments
            tvViews.text = post.views
            tvTime.text = post.publishDate
            tvShares.text = post.shares

            Picasso.with(itemView.context)
                .load(post.imgURL)
                .into(ivPost)

            Picasso.with(itemView.context)
                .load(post.imgURL)
                .into(ivGroupPhoto)


            ibLikes.setOnClickListener {
                Toast.makeText(itemView.context, "You liked this post", Toast.LENGTH_SHORT).show()
                tvLikes.text = (tvLikes.text).toString().toInt().plus(1).toString()
            }

            itemView.setOnClickListener {
                itemClickListener?.itemClick(adapterPosition, post)
            }
        }
    }

    interface RecyclerViewItemClick {
        fun itemClick(position: Int, item: ListItem)
    }
}