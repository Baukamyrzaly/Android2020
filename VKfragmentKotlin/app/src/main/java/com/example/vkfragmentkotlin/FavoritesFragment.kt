package com.example.vkfragmentkotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vkfragmentkotlin.models.News

class FavoritesFragment : Fragment(), LikedNewsAdapter.RecyclerViewItemClick {

    private lateinit var favRecyclerView: RecyclerView
    private lateinit var likedNewsAdapter: LikedNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container,false)
    }

    //intent to open news details by click on view
    override fun itemClick(position: Int, item: News)  {
        val intent = Intent(activity, NewsDetailActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

    //init of favorite recyclerview and adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favRecyclerView = activity!!.findViewById(R.id.fav_recyclerView)
        favRecyclerView.layoutManager = LinearLayoutManager(activity)
        likedNewsAdapter = LikedNewsAdapter(favoriteList,itemClickListener = this)
        favRecyclerView.adapter = likedNewsAdapter
    }

    //Container of favorite news
    companion object {
        val favoriteList: MutableList<News> = ArrayList()
    }
}