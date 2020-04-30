package com.example.vkfragmentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.vkfragmentkotlin.models.News
import de.hdodenhof.circleimageview.CircleImageView

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val imageName = findViewById<TextView>(R.id.image_name)
        val timeName = findViewById<TextView>(R.id.time_name)
        val contentName = findViewById<TextView>(R.id.content_name)
        val image = findViewById<CircleImageView>(R.id.image)
        val contentImage = findViewById<ImageView>(R.id.content_image)
        val likeNum = findViewById<TextView>(R.id.like_num)
        val viewsNum = findViewById<TextView>(R.id.views_num)
        val shareNum = findViewById<TextView>(R.id.share_num)
        val likeBtn = findViewById<ImageView>(R.id.ic_like_logo)
        val leftBar = findViewById<ImageView>(R.id.leftbar)

        val mEdit = findViewById<EditText>(R.id.editComment)
        mEdit.setOnClickListener({ v -> mEdit.isFocusableInTouchMode})

        //getting concrete news from intent
        val detailedNews  = intent.getParcelableExtra<News>("news")!!

        imageName.text = detailedNews.imageName
        timeName.text  = detailedNews.timeName
        contentName.text = detailedNews.contentName
        Glide.with(image.context).load(detailedNews.image).into(image)
        Glide.with(contentImage.context).load(detailedNews.contentImage).into(contentImage)
        likeNum.text = detailedNews.likeNum.toString()
        viewsNum.text = detailedNews.viewsNum.toString()
        shareNum.text = detailedNews.shareNum.toString()
        if (detailedNews.liked == 0)
            Glide.with(likeBtn.context).load(R.drawable.ic_favorite_black).into(likeBtn)
        else
            Glide.with(likeBtn.context).load(R.drawable.ic_like).into(likeBtn)

        //Like the post listener
        likeBtn.setOnClickListener(){
            val temp = likeNum.text.toString()
            var index = Integer.parseInt(temp)
            if (detailedNews.liked==1){
                index = index-1
                detailedNews.liked = 0
                likeNum.text = index.toString()
                likeBtn.setImageResource(R.drawable.ic_favorite_black)
                val toastRemoveLike = Toast.makeText(it.context,"Like removed", Toast.LENGTH_LONG)
                toastRemoveLike.setGravity(Gravity.CENTER,0,0);
                toastRemoveLike.show()
            } else {
                index = index+1
                detailedNews.liked = 1
                likeBtn.setImageResource(R.drawable.ic_like)
                likeNum.text = index.toString()
                val toastAddedLike = Toast.makeText(it.context, "Like done!", Toast.LENGTH_LONG)
                toastAddedLike.setGravity(Gravity.CENTER,0,0)
                toastAddedLike.show()
            }
        }

        //Go back to news list
        leftBar.setOnClickListener(){
            val intetnHome = Intent(it.context,MainActivity::class.java)
            startActivity(intetnHome)
        }

    }
}
