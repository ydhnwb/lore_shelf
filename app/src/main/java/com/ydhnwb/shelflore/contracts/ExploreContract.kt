package com.ydhnwb.shelflore.contracts

import com.ydhnwb.shelflore.models.Volume

interface ExploreContract {
    interface ExploreView{
        fun toast(message : String)
        fun attachToRecycler(books : List<Volume>)
        fun showLoading()
        fun hideLoading()
        fun showEmptyView(b : Boolean)
        fun showErrorView(b : Boolean)
    }

    interface ExploreInteractor{
        fun search(query : String)
        fun destroy()
    }
}