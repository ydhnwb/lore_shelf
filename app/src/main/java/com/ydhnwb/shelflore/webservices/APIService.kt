package com.ydhnwb.shelflore.webservices

import com.ydhnwb.shelflore.converters.SearchConverter
import com.ydhnwb.shelflore.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("volumes")
    fun search(@Query("q") q : String, @Query("key") key : String) : Call<SearchConverter>
}