package com.example.vkfragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottmNav: BottomNavigationView

    private lateinit var homeFragment:HomeFragment
    private lateinit var favoritesFragment:FavoritesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottmNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottmNav.setOnNavigationItemSelectedListener(navListener)

        //init of fragments
        homeFragment= HomeFragment()
        favoritesFragment = FavoritesFragment()

        //set homefragmetn as default
        setFragment(homeFragment)
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.nav_home -> {
               setFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_fav ->{
                setFragment(favoritesFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
       false
    }

    //replacing fragments while swtiching
    private fun setFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}
