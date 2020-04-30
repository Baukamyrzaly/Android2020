package com.example.ktvkontakte

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity(), ListAdapter.RecyclerViewItemClick {

    lateinit var recyclerView: RecyclerView
    private var newsAdapter: ListAdapter? = null
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        recyclerView = findViewById(R.id.mainRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsAdapter = ListAdapter(generateList(), itemClickListener = this)
        recyclerView.adapter = newsAdapter

    }

    override fun itemClick(position: Int, item: ListItem) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

    private fun generateList(): List<ListItem> {

        var newsList: MutableList<ListItem> = ArrayList()

        try {
            val obj = JSONObject(loadJSONFromAsset(context))
            val arrayPost: JSONArray = obj.getJSONArray("posts")

            for (i in 0..arrayPost.length()) {
                Log.i("loop", "error")
                var ls = ListItem()
                var joInside = arrayPost.getJSONObject(i)

                var heading = joInside.getString("heading")
                var time = joInside.getString("time")
                var title = joInside.getString("title")
                var likes = joInside.getString("likes")
                var comments = joInside.getString("comments")
                var shares = joInside.getString("shares")
                var views = joInside.getString("views")
                var imgURL = joInside.getString("gImage")

                ls.groupName = heading
                ls.publishDate = time
                ls.heading = title
                ls.likes = likes
                ls.comments = comments
                ls.shares = shares
                ls.views = views
                ls.imgURL = imgURL

                newsList.add(ls)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return newsList
    }

    private fun loadJSONFromAsset(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("a.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}