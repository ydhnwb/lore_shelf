package com.ydhnwb.shelflore

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.google.android.material.appbar.AppBarLayout
import com.ydhnwb.shelflore.models.VolumeInfo
import com.ydhnwb.shelflore.ui.detail.VpPagerAdapter
import com.ydhnwb.shelflore.utils.Constants
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        init()
    }

    private fun init(){
        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val isShow = false
            var scrollRange = -1
            if (scrollRange == -1) { scrollRange = appBarLayout.totalScrollRange }
            when {
                scrollRange + verticalOffset == 0 -> {
                    val s : String = if (supportActionBar?.title == null)  " " else getVolume().title
                    toolbar_layout.title = s
                }
                isShow -> toolbar_layout.title = " "
                scrollRange + verticalOffset > 0 -> toolbar_layout.title = " "
            }
        })

        detail_backround.load(Constants.getBetterThumb(getVolume().imageLink.thumbnail)){
            crossfade(true)
            crossfade(1500)
        }
        detail_vp.adapter = VpPagerAdapter(supportFragmentManager, getVolume())
    }

    private fun getVolume() : VolumeInfo = intent.getParcelableExtra("VOLUME")
}
