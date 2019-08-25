package com.ydhnwb.shelflore.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import com.ydhnwb.shelflore.R
import com.ydhnwb.shelflore.models.VolumeInfo
import com.ydhnwb.shelflore.utils.Constants
import kotlinx.android.synthetic.main.vp_detail_info.view.*

class VpInfoFragment (volumeInfo: VolumeInfo) : Fragment(){
    private var v = volumeInfo
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vp_detail_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.vp_detail_title.text = v.title
        view.vp_detail_desc.text = v.subtitle
        view.vp_detail_author.text = if (v.authors.isEmpty()) "Author not available" else v.authors[0]
    }
}