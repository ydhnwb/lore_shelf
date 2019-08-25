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
import kotlinx.android.synthetic.main.vp_detail_main.view.*

class VpMainFragment(volumeInfo : VolumeInfo) : Fragment() {
    private var v = volumeInfo

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vp_detail_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.book_image.load(Constants.getBetterThumb(v.imageLink.thumbnail))
        view.book_rating.rating = v.averageRating
        view.book_title.text = v.title
        view.book_ratingcount.text = "(${v.ratingsCount})"
    }
}
