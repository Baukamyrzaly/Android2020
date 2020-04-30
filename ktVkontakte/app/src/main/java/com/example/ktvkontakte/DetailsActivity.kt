package com.example.ktvkontakte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val actionbar = supportActionBar
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val tvGroup = findViewById<TextView>(R.id.tvGroup)
        val tvTime = findViewById<TextView>(R.id.tvTime)
        val tvHeading = findViewById<TextView>(R.id.tvHeading)
        val tvLikes = findViewById<TextView>(R.id.tvLikes)
        val tvComments = findViewById<TextView>(R.id.tvComment)
        val tvViews = findViewById<TextView>(R.id.tvViews)
        val ivPost = findViewById<ImageView>(R.id.ivPost)
        val ivGroupPhoto = findViewById<ImageView>(R.id.ivGroupPhoto)
        val ibLikes = findViewById<ImageButton>(R.id.iblike)
        val tvShares = findViewById<TextView>(R.id.tvShare)

        val list  = intent.getParcelableExtra<ListItem>("news")!!


        tvGroup.text = list.groupName
        tvHeading.text = list.heading
        tvLikes.text = list.likes
        tvComments.text = list.comments
        tvViews.text = list.views
        tvTime.text = list.publishDate
        tvShares.text = list.shares

        Picasso.with(this)
            .load(list.imgURL)
            .into(ivPost)

        Picasso.with(this)
            .load(list.imgURL)
            .into(ivGroupPhoto)


        ibLikes.setOnClickListener {
            Toast.makeText(this, "You liked this post", Toast.LENGTH_SHORT).show()
            tvLikes.text = (tvLikes.text).toString().toInt().plus(1).toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
