package com.example.vkfragmentkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vkfragmentkotlin.models.DataNews
import com.example.vkfragmentkotlin.models.News

class HomeFragment : Fragment(), NewsAdapter.RecyclerViewItemClick  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter

    private val STATE = "recycler_view"
    private var recyclerViewState: Bundle?=null

    lateinit var  items : List<News>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return  inflater.inflate(R.layout.fragment_home,container,false)
    }

    //click to intent for details of news
    override fun itemClick(position: Int, item: News)  {
        val intent = Intent(activity, NewsDetailActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

    //init of recyclerview and adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = activity!!.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        newsAdapter = NewsAdapter(GenerateNews(),itemClickListener = this)
        recyclerView.adapter = newsAdapter
    }

    //overriding fun to restore saved state of recyclerview
    override fun onResume() {
        super.onResume()
        if (recyclerViewState!=null){
            val listState = recyclerViewState!!.getParcelable<Parcelable>(STATE)
            recyclerView.layoutManager!!.onRestoreInstanceState(listState)
        }
    }

    //overriding fun to save the state of recyclerview news
    override fun onPause() {
        super.onPause()
        recyclerViewState = Bundle()
        val listState = recyclerView.layoutManager!!.onSaveInstanceState()
        recyclerViewState!!.putParcelable(STATE, listState)
    }

    //fetching news list from dataNews object
    fun GenerateNews() : List<News>  {
       items = DataNews.newsBIG
        return items
    }
}