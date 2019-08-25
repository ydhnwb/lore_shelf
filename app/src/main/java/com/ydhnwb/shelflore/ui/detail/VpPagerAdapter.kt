package com.ydhnwb.shelflore.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ydhnwb.shelflore.models.VolumeInfo

class VpPagerAdapter(fm: FragmentManager, volume : VolumeInfo): FragmentPagerAdapter(fm){

    private val pages = listOf(VpMainFragment(volume), VpInfoFragment(volume))

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount() = pages.size
}