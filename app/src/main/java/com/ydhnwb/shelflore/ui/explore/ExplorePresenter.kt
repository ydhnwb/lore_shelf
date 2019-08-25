package com.ydhnwb.shelflore.ui.explore

import com.ydhnwb.shelflore.contracts.ExploreContract
import com.ydhnwb.shelflore.converters.SearchConverter
import com.ydhnwb.shelflore.utils.APIClient
import com.ydhnwb.shelflore.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ExplorePresenter(private var view: ExploreContract.ExploreView?) : ExploreContract.ExploreInteractor {
    private var api = APIClient.APIService()
    private var key = Constants.TOKEN_BOOKS

    override fun search(query: String) {
        view?.showLoading()
        view?.showEmptyView(false)
        api.search(query, key, 40).enqueue(object : Callback<SearchConverter>{
            override fun onFailure(call: Call<SearchConverter>, t: Throwable) {
                println(t.message)
                view?.toast("Cannot connect to the server")
            }

            override fun onResponse(call: Call<SearchConverter>, response: Response<SearchConverter>) {
                if(response.isSuccessful){
                    response.body()?.let {it ->
                        var items = it.items
                        if(items.isNotEmpty()){
                            items = items.sortedByDescending{
                                it.volumeInfo.ratingsCount
                            }
                            view?.attachToRecycler(items)
                        }else{
                            view?.showEmptyView(true)
                        }
                        view?.hideLoading()
                    }
                }else{
                    view?.hideLoading()
                    view?.toast("Something went wrong")
                }
            }
        })
    }

    override fun destroy() { view = null}
}