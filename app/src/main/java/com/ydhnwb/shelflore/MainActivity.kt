package com.ydhnwb.shelflore

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.Fade
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ydhnwb.shelflore.ui.explore.ExploreFragment
import com.ydhnwb.shelflore.ui.library.LibraryFragment
import com.ydhnwb.shelflore.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    companion object{ var nav_status = -1 }
    private var fragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if(savedInstanceState == null) nav_view.selectedItemId = R.id.navigation_library
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.navigation_library -> {
                if(nav_status != 0){
                    fragment = LibraryFragment()
                    nav_status = 0
                }
            }
            R.id.navigation_explore -> {
                if(nav_status != 1){
                    fragment = ExploreFragment()
                    nav_status = 1
                }
            }

            R.id.navigation_profile -> {
                if(nav_status != 2){
                    fragment = ProfileFragment()
                    nav_status = 2
                }
            }
            else -> {
                nav_status = 0
                fragment = LibraryFragment()
            }
        }
        if(fragment == null){
            nav_status = 0
            fragment = LibraryFragment()
        }
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment!!)
        fragmentTransaction.commit()
        true
    }

    override fun onStart() {
        super.onStart()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }


}
