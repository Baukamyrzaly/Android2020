package com.example.vkfragmentkotlin

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vkfragmentkotlin.models.News
import de.hdodenhof.circleimageview.CircleImageView

class LikedNewsAdapter(
    var favriteList: List<News>,
    val itemClickListener: RecyclerViewItemClick? = null
) : RecyclerView.Adapter<LikedNewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.layout_listitem, p0, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = favriteList.size ?: 0

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(favriteList.get(position))
    }

    inner class NewsViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(post: News) {

            val imageName = view.findViewById<TextView>(R.id.image_name)
            val timeName = view.findViewById<TextView>(R.id.time_name)
            val contentName = view.findViewById<TextView>(R.id.content_name)
            val image = view.findViewById<CircleImageView>(R.id.image)
            val contentImage = view.findViewById<ImageView>(R.id.content_image)
            val likeNum = view.findViewById<TextView>(R.id.like_num)
            val commentNum = view.findViewById<TextView>(R.id.comment_num)
            val shareNum = view.findViewById<TextView>(R.id.share_num)
            val likeBtn = view.findViewById<ImageView>(R.id.ic_like_logo)

            imageName.text = post.imageName
            timeName.text = post.timeName
            contentName.text = post.contentName
            Glide.with(image.context).load(post.image).into(image)
            Glide.with(contentImage.context).load(post.contentImage).into(contentImage)
            likeNum.text = post.likeNum.toString()
            commentNum.text = post.commentNum.toString()
            shareNum.text = post.shareNum.toString()

            if (post.liked==1){
                Glide.with(likeBtn.context).load(R.drawable.ic_like).into(likeBtn)
            } else{
                Glide.with(likeBtn.context).load(R.drawable.ic_favorite_black).into(likeBtn)
            }

            likeBtn.setOnClickListener(){
                if (itemClickListener!=null) {
                    if (post.liked == 1) {
                        FavoritesFragment.favoriteList.remove(post)
                        post.liked = 0
                        post.likeNum = post.likeNum - 1
                        likeBtn.setImageResource(R.drawable.ic_favorite_black)
                        likeNum.text = post.likeNum.toString()
                        notifyDataSetChanged()
                        val t = Toast.makeText(view.context, "Like removed", Toast.LENGTH_SHORT)
                        t.setGravity(Gravity.CENTER, 0, 0)
                        t.show()
                    }
                }
            }

            view.setOnClickListener {
                itemClickListener?.itemClick(adapterPosition, post)
            }
        }
    }

    interface RecyclerViewItemClick {
        fun itemClick(position: Int, item: News)
    }
}