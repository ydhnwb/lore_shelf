package com.ydhnwb.shelflore.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.mancj.materialsearchbar.MaterialSearchBar
import com.ydhnwb.shelflore.R
import com.ydhnwb.shelflore.adapters.SearchAdapter
import com.ydhnwb.shelflore.contracts.ExploreContract
import com.ydhnwb.shelflore.models.Volume
import kotlinx.android.synthetic.main.etc_empty_view_search.view.*
import kotlinx.android.synthetic.main.etc_hint_view_search.view.*
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kotlinx.android.synthetic.main.fragment_explore.view.spin_kit

class ExploreFragment : Fragment(), ExploreContract.ExploreView {
    private var presenter : ExplorePresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_explore, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ExplorePresenter(this)
        view.search_bar.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener{
            override fun onButtonClicked(buttonCode: Int) {}
            override fun onSearchStateChanged(enabled: Boolean) {}
            override fun onSearchConfirmed(text: CharSequence?) {
                text?.isNotEmpty().let {b ->
                    if(b == true)
                        view.etc_hint.visibility = View.GONE
                        presenter?.search(text.toString().trim())
                }
            }
        })
     }

    override fun toast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_LONG).show()

    override fun attachToRecycler(books: List<Volume>) {
        view!!.rv_search.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = SearchAdapter(books, activity!!)
        }.also {
            it.adapter?.notifyDataSetChanged()
            it.scheduleLayoutAnimation()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }

    override fun showLoading()  {
        view!!.spin_kit.apply {
            setIndeterminateDrawable(DoubleBounce())
            view!!.spin_kit.isIndeterminate = true
            visibility = View.VISIBLE
        }
    }

    override fun hideLoading() {
        view!!.spin_kit.apply {
            visibility = View.GONE
        }
    }

    override fun showEmptyView(b: Boolean) {
        if(b) view!!.etc_empty.visibility = View.VISIBLE else view!!.etc_empty.visibility = View.GONE
    }

    override fun showErrorView(b: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}